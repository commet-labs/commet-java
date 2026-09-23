package co.commet.resources;

import co.commet.CommetHttpClient;
import co.commet.params.CreateApiKeyParams;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ApiKeysResourceTest {
    private final ObjectMapper mapper = new ObjectMapper();

    private JsonNode sentBody(CreateApiKeyParams params) throws Exception {
        try (MockWebServer server = new MockWebServer()) {
            server.start();
            server.enqueue(new MockResponse().setResponseCode(201).setBody("{}"));
            CommetHttpClient http = new QuotaResourceTest.TestableHttpClient(
                    "ck_test_key", server.url("/").toString(), Duration.ofSeconds(5), 0);
            new ApiKeysResource(http).create(params);
            return mapper.readTree(server.takeRequest().getBody().readUtf8());
        }
    }

    @Test
    void omittedPermissionsStayOmitted() throws Exception {
        JsonNode body = sentBody(CreateApiKeyParams.builder("Example").build());
        assertFalse(body.has("permissions"));
    }

    @Test
    void emptyPermissionsStayAnObject() throws Exception {
        JsonNode body = sentBody(CreateApiKeyParams.builder("Example")
                .permissions(Map.of()).build());
        assertTrue(body.get("permissions").isObject());
        assertEquals(0, body.get("permissions").size());
    }

    @Test
    void underscoredPermissionResourceStaysLiteral() throws Exception {
        JsonNode body = sentBody(CreateApiKeyParams.builder("Example")
                .permissions(Map.of("plan_group", List.of("read"))).build());
        assertEquals("read", body.get("permissions").get("plan_group").get(0).asText());
        assertFalse(body.get("permissions").has("planGroup"));
    }
}
