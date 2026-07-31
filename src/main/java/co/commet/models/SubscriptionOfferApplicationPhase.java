package co.commet.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;

@JsonDeserialize(using = SubscriptionOfferApplicationPhase.Deserializer.class)
public interface SubscriptionOfferApplicationPhase {
    final class Deserializer extends JsonDeserializer<SubscriptionOfferApplicationPhase> {
        @Override
        public SubscriptionOfferApplicationPhase deserialize(JsonParser parser, DeserializationContext context) throws IOException {
            ObjectMapper mapper = (ObjectMapper) parser.getCodec();
            JsonNode node = mapper.readTree(parser);
            JsonNode discriminator = node.get("type");
            if (discriminator != null) {
                switch (discriminator.asText()) {
                    case "free_trial":
                        return mapper.treeToValue(node, SubscriptionOfferApplicationPhaseVariant1.class);
                    case "percentage":
                        return mapper.treeToValue(node, SubscriptionOfferApplicationPhaseVariant2.class);
                    case "amount_off":
                        return mapper.treeToValue(node, SubscriptionOfferApplicationPhaseVariant3.class);
                    case "fixed_price":
                        return mapper.treeToValue(node, SubscriptionOfferApplicationPhaseVariant4.class);
                    default:
                        break;
                }
            }
            return mapper.treeToValue(node, SubscriptionOfferApplicationPhaseVariant1.class);
        }
    }
}
