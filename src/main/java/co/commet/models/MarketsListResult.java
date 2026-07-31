package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MarketsListResult(
        @JsonProperty("object") String object,
        @JsonProperty("data") List<Market> data,
        @JsonProperty("has_more") boolean hasMore,
        @JsonProperty("next_cursor") String nextCursor
) {}
