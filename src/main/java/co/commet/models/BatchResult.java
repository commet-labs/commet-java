package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BatchResult(
        @JsonProperty("successful") List<Customer> successful,
        @JsonProperty("failed") List<BatchFailure> failed
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record BatchFailure(
            @JsonProperty("index") int index,
            @JsonProperty("error") String error,
            @JsonProperty("data") Map<String, Object> data
    ) {}
}
