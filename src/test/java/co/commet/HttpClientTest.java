package co.commet;

import co.commet.models.CreateApiKeyParamsPermissions;
import co.commet.models.CreateCustomerParamsAddress;
import co.commet.models.CreateOfferParamsPhasesItemVariant2;
import com.fasterxml.jackson.databind.JsonNode;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HttpClientTest {

    @Test
    void requestSerializationPreservesPermissionsAndRequiredNull() throws Exception {
        try (CommetHttpClient http = new CommetHttpClient("rk_test", Duration.ofSeconds(1), 0, false)) {
            var mapper = http.getObjectMapper();
            var permissions = new CreateApiKeyParamsPermissions(
                    null, null, null, null, null, null, List.of("read"), null, null, List.of("write"),
                    null, List.of("read", "write"), List.of("read"), null, null, null,
                    List.of("write"), null, List.of("read"));
            Map<String, Object> body = CommetHttpClient.buildBody(
                    "expires_in_days", 30, "permissions", mapper.valueToTree(permissions),
                    "address", new CreateCustomerParamsAddress("Main", null, "City", null, "123", "US", null),
                    "phases", List.of(new CreateOfferParamsPhasesItemVariant2("percentage", null, "month", 0)));
            body.put("duration_days", null);
            JsonNode actual = mapper.readTree(mapper.writeValueAsString(http.serializeRequestBody(body)));
            assertEquals(mapper.readTree("""
                    {"plan_group":["read"],"credit_pack":["write"],"promo_code":["read","write"],
                     "market_group":["read"],"test_clock":["write"],"api_key":["read"]}
                    """), actual.get("permissions"));
            assertEquals(30, actual.get("expiresInDays").asInt());
            assertTrue(actual.get("durationDays").isNull());
            assertEquals(mapper.readTree("""
                    {"line1":"Main","city":"City","postalCode":"123","country":"US"}
                    """), actual.get("address"));
            assertTrue(actual.get("phases").get(0).get("durationCycles").isNull());
            var emptyPermissions = new CreateApiKeyParamsPermissions(null, null, null, null, null,
                    null, null, null, null, null, null, null, null, null, null, null, null, null, null);
            assertEquals("{\"permissions\":{}}", mapper.writeValueAsString(http.serializeRequestBody(
                    CommetHttpClient.buildBody("permissions", mapper.valueToTree(emptyPermissions)))));
            assertEquals("{}", mapper.writeValueAsString(http.serializeRequestBody(
                    CommetHttpClient.buildBody("permissions", null))));
        }
    }

    @Test
    void camelToSnakeBasicConversion() {
        assertEquals("hello_world", CommetHttpClient.toSnake("helloWorld"));
        assertEquals("customer_id", CommetHttpClient.toSnake("customerId"));
        assertEquals("billing_email", CommetHttpClient.toSnake("billingEmail"));
    }

    @Test
    void camelToSnakeConsecutiveCapitals() {
        assertEquals("api_key", CommetHttpClient.toSnake("APIKey"));
        assertEquals("get_http_response", CommetHttpClient.toSnake("getHTTPResponse"));
    }

    @Test
    void camelToSnakeAlreadySnakeCase() {
        assertEquals("already_snake", CommetHttpClient.toSnake("already_snake"));
    }

    @Test
    void camelToSnakeSingleWord() {
        assertEquals("name", CommetHttpClient.toSnake("name"));
    }

    @Test
    void snakeToCamelBasicConversion() {
        assertEquals("helloWorld", CommetHttpClient.toCamel("hello_world"));
        assertEquals("customerId", CommetHttpClient.toCamel("customer_id"));
        assertEquals("billingEmail", CommetHttpClient.toCamel("billing_email"));
    }

    @Test
    void snakeToCamelSingleWord() {
        assertEquals("name", CommetHttpClient.toCamel("name"));
    }

    @Test
    void snakeToCamelMultipleUnderscores() {
        assertEquals("veryLongPropertyName", CommetHttpClient.toCamel("very_long_property_name"));
    }

    @Test
    void snakeToCamelAlreadyCamelCase() {
        assertEquals("alreadyCamel", CommetHttpClient.toCamel("alreadyCamel"));
    }

    @Test
    void snakeToCamelTrailingUnderscore() {
        assertEquals("trailing_", CommetHttpClient.toCamel("trailing_"));
    }

    @Test
    void roundTripConversion() {
        String original = "billing_interval";
        assertEquals(original, CommetHttpClient.toSnake(CommetHttpClient.toCamel(original)));
    }
}
