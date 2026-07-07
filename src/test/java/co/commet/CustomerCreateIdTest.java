package co.commet;

import co.commet.models.BatchCreateCustomersParamsCustomersItem;
import co.commet.params.BatchCreateCustomersParams;
import co.commet.params.CreateCustomerParams;
import co.commet.resources.CustomersResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CustomerCreateIdTest {

    private MockWebServer server;
    private CustomersResource customers;
    private final ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    void setUp() throws IOException {
        server = new MockWebServer();
        server.start();
        String baseUrl = server.url("/").toString();
        CommetHttpClient http = new ErrorParsingTest.TestableHttpClient("ck_test_key", baseUrl, Duration.ofSeconds(5), 0);
        customers = new CustomersResource(http);
    }

    @AfterEach
    void tearDown() throws IOException {
        server.shutdown();
    }

    private void enqueueCustomer() {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody("{\"success\":true,\"data\":{\"id\":\"cus_x\",\"email\":\"a@b.com\",\"created_at\":\"2024-01-01T00:00:00Z\",\"updated_at\":\"2024-01-01T00:00:00Z\"}}"));
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> bodyOf(RecordedRequest request) throws IOException {
        return mapper.readValue(request.getBody().readUtf8(), Map.class);
    }

    @Test
    void createSendsId() throws Exception {
        enqueueCustomer();

        customers.create(CreateCustomerParams.builder("a@b.com").id("ext_123").build());

        Map<String, Object> body = bodyOf(server.takeRequest());
        assertEquals("ext_123", body.get("id"));
        assertEquals("a@b.com", body.get("email"));
    }

    @Test
    void createOmitsIdWhenNull() throws Exception {
        enqueueCustomer();

        customers.create(CreateCustomerParams.builder("a@b.com").build());

        Map<String, Object> body = bodyOf(server.takeRequest());
        assertFalse(body.containsKey("id"));
    }

    @Test
    @SuppressWarnings("unchecked")
    void createBatchSendsId() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody("{\"success\":true,\"data\":{\"successful\":[],\"failed\":[]}}"));

        customers.createBatch(BatchCreateCustomersParams.builder(List.of(
                new BatchCreateCustomersParamsCustomersItem("a@b.com", "ext_a", null, null, null, null, null, null),
                new BatchCreateCustomersParamsCustomersItem("b@b.com", null, null, null, null, null, null, null)
        )).build());

        Map<String, Object> body = bodyOf(server.takeRequest());
        List<Map<String, Object>> sent = (List<Map<String, Object>>) body.get("customers");
        assertEquals(2, sent.size());
        assertEquals("ext_a", sent.get(0).get("id"));
        assertFalse(sent.get(1).containsKey("id"));
    }
}
