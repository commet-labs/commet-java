package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CustomerBatch(
        @JsonProperty("successful") List<CustomerBatchSuccessfulItem> successful,
        @JsonProperty("failed") List<CustomerBatchFailedItem> failed,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
