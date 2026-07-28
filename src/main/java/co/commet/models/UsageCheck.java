package co.commet.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;

@JsonDeserialize(using = UsageCheck.Deserializer.class)
public interface UsageCheck {
    final class Deserializer extends JsonDeserializer<UsageCheck> {
        @Override
        public UsageCheck deserialize(JsonParser parser, DeserializationContext context) throws IOException {
            ObjectMapper mapper = (ObjectMapper) parser.getCodec();
            JsonNode node = mapper.readTree(parser);
            JsonNode discriminator = node.get("consumption_model");
            if (discriminator != null) {
                switch (discriminator.asText()) {
                    case "metered":
                        return mapper.treeToValue(node, UsageCheckVariant1.class);
                    case "credits":
                        return mapper.treeToValue(node, UsageCheckVariant2.class);
                    case "balance":
                        return mapper.treeToValue(node, UsageCheckVariant3.class);
                    default:
                        break;
                }
            }
            return mapper.treeToValue(node, UsageCheckVariant1.class);
        }
    }
}
