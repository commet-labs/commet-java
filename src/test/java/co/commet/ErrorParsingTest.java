package co.commet;

import co.commet.models.Customer;
import co.commet.resources.CustomersResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ErrorParsingTest {

    private MockWebServer server;
    private CustomersResource customers;
    private final ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    void setUp() throws IOException {
        server = new MockWebServer();
        server.start();

        String baseUrl = server.url("/").toString();
        CommetHttpClient http = new TestableHttpClient("ck_test_key", baseUrl, Duration.ofSeconds(5), 0);
        customers = new CustomersResource(http);
    }

    @AfterEach
    void tearDown() throws IOException {
        server.shutdown();
    }

    @Test
    void apiErrorThrowsCommetApiException() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(403)
                .setHeader("Content-Type", "application/json")
                .setBody(mapper.writeValueAsString(Map.of(
                        "success", false,
                        "code", "forbidden",
                        "message", "Access denied"
                ))));

        CommetApiException exception = assertThrows(CommetApiException.class,
                () -> customers.get("cus_123"));

        assertEquals("Access denied", exception.getMessage());
        assertEquals("forbidden", exception.getCode());
        assertEquals(403, exception.getStatusCode());
    }

    @Test
    void validationErrorThrowsCommetValidationException() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(422)
                .setHeader("Content-Type", "application/json")
                .setBody(mapper.writeValueAsString(Map.of(
                        "success", false,
                        "code", "validation_error",
                        "message", "Validation failed",
                        "details", List.of(
                                Map.of("field", "email", "message", "Email is required"),
                                Map.of("field", "email", "message", "Must be a valid email"),
                                Map.of("field", "name", "message", "Name is too short")
                        )
                ))));

        CommetValidationException exception = assertThrows(CommetValidationException.class,
                () -> customers.create(""));

        assertEquals("Validation failed", exception.getMessage());

        Map<String, List<String>> errors = exception.getValidationErrors();
        assertEquals(2, errors.size());
        assertEquals(List.of("Email is required", "Must be a valid email"), errors.get("email"));
        assertEquals(List.of("Name is too short"), errors.get("name"));
    }

    @Test
    void notFoundWithJsonReturnsError() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(404)
                .setHeader("Content-Type", "application/json")
                .setBody(mapper.writeValueAsString(Map.of(
                        "success", false,
                        "code", "not_found",
                        "message", "Customer not found"
                ))));

        CommetApiException exception = assertThrows(CommetApiException.class,
                () -> customers.get("cus_nonexistent"));

        assertEquals("Customer not found", exception.getMessage());
        assertEquals("not_found", exception.getCode());
        assertEquals(404, exception.getStatusCode());
    }

    @Test
    void notFoundWithInvalidJsonThrowsCommetApiException() {
        server.enqueue(new MockResponse()
                .setResponseCode(404)
                .setBody("Not Found"));

        CommetApiException exception = assertThrows(CommetApiException.class,
                () -> customers.get("cus_nonexistent"));

        assertEquals("INVALID_JSON", exception.getCode());
    }

    @Test
    void serverErrorWithInvalidJsonThrowsCommetApiException() {
        server.enqueue(new MockResponse()
                .setResponseCode(500)
                .setBody("Internal Server Error"));

        CommetApiException exception = assertThrows(CommetApiException.class,
                () -> customers.get("cus_123"));

        assertEquals("INVALID_JSON", exception.getCode());
    }

    @Test
    void successfulResponseReturnsTypedData() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody(mapper.writeValueAsString(Map.of(
                        "success", true,
                        "data", Map.of(
                                "id", "cus_abc123",
                                "billing_email", "user@example.com",
                                "is_active", true,
                                "created_at", "2024-01-01T00:00:00Z",
                                "updated_at", "2024-01-01T00:00:00Z"
                        )
                ))));

        ApiResponse<Customer> response = customers.get("cus_abc123");

        assertTrue(response.isSuccess());
        assertNotNull(response.getData());
        assertEquals("cus_abc123", response.getData().id());
        assertEquals("user@example.com", response.getData().billingEmail());
        assertTrue(response.getData().isActive());
    }

    @Test
    void listResponseReturnsTypedList() throws Exception {
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setHeader("Content-Type", "application/json")
                .setBody(mapper.writeValueAsString(Map.of(
                        "success", true,
                        "data", List.of(
                                Map.of("id", "cus_1", "billing_email", "a@test.com",
                                        "is_active", true, "created_at", "2024-01-01T00:00:00Z",
                                        "updated_at", "2024-01-01T00:00:00Z"),
                                Map.of("id", "cus_2", "billing_email", "b@test.com",
                                        "is_active", false, "created_at", "2024-01-01T00:00:00Z",
                                        "updated_at", "2024-01-01T00:00:00Z")
                        ),
                        "has_more", true,
                        "next_cursor", "cursor_abc"
                ))));

        ApiResponse<List<Customer>> response = customers.list();

        assertTrue(response.isSuccess());
        assertEquals(2, response.getData().size());
        assertEquals("cus_1", response.getData().get(0).id());
        assertEquals("cus_2", response.getData().get(1).id());
        assertTrue(response.getHasMore());
        assertEquals("cursor_abc", response.getNextCursor());
    }

    static class TestableHttpClient extends CommetHttpClient {
        TestableHttpClient(String apiKey, String baseUrl, Duration timeout, int retries) {
            super(apiKey, timeout, retries);
            try {
                var field = CommetHttpClient.class.getDeclaredField("baseUrl");
                field.setAccessible(true);
                field.set(this, baseUrl + "api");
            } catch (Exception e) {
                throw new RuntimeException("Failed to set base URL for testing", e);
            }
        }
    }
}
