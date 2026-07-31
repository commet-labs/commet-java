package co.commet.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public record UpdateOfferParamsPhasesItemVariant3(
        @JsonProperty("type") String type,
        @JsonProperty("duration_cycles") Long durationCycles,
        @JsonProperty("amounts") List<UpdateOfferParamsPhasesItemVariant3AmountsItem> amounts
) implements UpdateOfferParamsPhasesItem {}
