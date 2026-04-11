package co.commet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HttpClientTest {

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
