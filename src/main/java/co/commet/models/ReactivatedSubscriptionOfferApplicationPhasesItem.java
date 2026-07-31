package co.commet.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;

@JsonDeserialize(using = ReactivatedSubscriptionOfferApplicationPhasesItem.Deserializer.class)
public interface ReactivatedSubscriptionOfferApplicationPhasesItem {
    final class Deserializer extends JsonDeserializer<ReactivatedSubscriptionOfferApplicationPhasesItem> {
        @Override
        public ReactivatedSubscriptionOfferApplicationPhasesItem deserialize(JsonParser parser, DeserializationContext context) throws IOException {
            ObjectMapper mapper = (ObjectMapper) parser.getCodec();
            JsonNode node = mapper.readTree(parser);
            JsonNode discriminator = node.get("type");
            if (discriminator != null) {
                switch (discriminator.asText()) {
                    case "free_trial":
                        return mapper.treeToValue(node, ReactivatedSubscriptionOfferApplicationPhasesItemVariant1.class);
                    case "percentage":
                        return mapper.treeToValue(node, ReactivatedSubscriptionOfferApplicationPhasesItemVariant2.class);
                    case "amount_off":
                        return mapper.treeToValue(node, ReactivatedSubscriptionOfferApplicationPhasesItemVariant3.class);
                    case "fixed_price":
                        return mapper.treeToValue(node, ReactivatedSubscriptionOfferApplicationPhasesItemVariant4.class);
                    default:
                        break;
                }
            }
            return mapper.treeToValue(node, ReactivatedSubscriptionOfferApplicationPhasesItemVariant1.class);
        }
    }
}
