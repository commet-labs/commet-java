package co.commet.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;

@JsonDeserialize(using = ReactivatedSubscriptionOfferApplicationAppliesTo.Deserializer.class)
public interface ReactivatedSubscriptionOfferApplicationAppliesTo {
    final class Deserializer extends JsonDeserializer<ReactivatedSubscriptionOfferApplicationAppliesTo> {
        @Override
        public ReactivatedSubscriptionOfferApplicationAppliesTo deserialize(JsonParser parser, DeserializationContext context) throws IOException {
            ObjectMapper mapper = (ObjectMapper) parser.getCodec();
            JsonNode node = mapper.readTree(parser);
            JsonNode discriminator = node.get("type");
            if (discriminator != null) {
                switch (discriminator.asText()) {
                    case "plan_price":
                        return mapper.treeToValue(node, ReactivatedSubscriptionOfferApplicationAppliesToVariant1.class);
                    case "addon":
                        return mapper.treeToValue(node, ReactivatedSubscriptionOfferApplicationAppliesToVariant2.class);
                    case "credit_pack":
                        return mapper.treeToValue(node, ReactivatedSubscriptionOfferApplicationAppliesToVariant3.class);
                    default:
                        break;
                }
            }
            return mapper.treeToValue(node, ReactivatedSubscriptionOfferApplicationAppliesToVariant1.class);
        }
    }
}
