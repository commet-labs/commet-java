package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreditPackListItem(
        @JsonProperty("id") String id,
        @JsonProperty("name") String name,
        @JsonProperty("description") String description,
        @JsonProperty("credits") long credits,
        @JsonProperty("price") long price,
        @JsonProperty("currency") String currency,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
