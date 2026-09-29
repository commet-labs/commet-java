package co.commet.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;

@JsonDeserialize(using = SubscriptionPause.Deserializer.class)
public interface SubscriptionPause {
    final class Deserializer extends JsonDeserializer<SubscriptionPause> {
        @Override
        public SubscriptionPause deserialize(JsonParser parser, DeserializationContext context) throws IOException {
            ObjectMapper mapper = (ObjectMapper) parser.getCodec();
            JsonNode node = mapper.readTree(parser);
            JsonNode discriminator = node.get("status");
            if (discriminator != null) {
                switch (discriminator.asText()) {
                    case "scheduled":
                        return mapper.treeToValue(node, SubscriptionPauseVariant1.class);
                    case "active":
                        return mapper.treeToValue(node, SubscriptionPauseVariant2.class);
                    default:
                        break;
                }
            }
            return mapper.treeToValue(node, SubscriptionPauseVariant1.class);
        }
    }
}
