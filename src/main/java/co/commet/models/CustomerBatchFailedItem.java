package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CustomerBatchFailedItem(
        @JsonProperty("index") long index,
        @JsonProperty("error") String error,
        @JsonProperty("data") CustomerBatchFailedItemData data
) {}
