package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record PlanChangeVariant4(
        @JsonProperty("outcome") String outcome,
        @JsonProperty("invoice_id") String invoiceId,
        @JsonProperty("object") String object,
        @JsonProperty("livemode") boolean livemode
) implements PlanChange {}
