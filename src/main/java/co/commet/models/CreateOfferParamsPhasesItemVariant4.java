package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record CreateOfferParamsPhasesItemVariant4(
        @JsonProperty("type") String type,
        @JsonProperty("duration_cycles") long durationCycles,
        @JsonProperty("prices") List<CreateOfferParamsPhasesItemVariant4PricesItem> prices
) implements CreateOfferParamsPhasesItem {}
