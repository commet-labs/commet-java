package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InvoiceSendResult(
        @JsonProperty("sent") boolean sent,
        @JsonProperty("sent_at") String sentAt
) {}
