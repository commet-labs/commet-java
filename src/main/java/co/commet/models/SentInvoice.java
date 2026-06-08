package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SentInvoice(
        @JsonProperty("sent") boolean sent,
        @JsonProperty("sent_at") String sentAt,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) {}
