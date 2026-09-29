package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record TransactionListItemPaymentContextRecoveryVariant2(
        @JsonProperty("type") String type,
        @JsonProperty("attempt") long attempt,
        @JsonProperty("max_attempts") long maxAttempts
) implements TransactionListItemPaymentContextRecovery {}
