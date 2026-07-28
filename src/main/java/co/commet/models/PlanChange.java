package co.commet.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;

@JsonDeserialize(using = PlanChange.Deserializer.class)
public interface PlanChange {
    final class Deserializer extends JsonDeserializer<PlanChange> {
        @Override
        public PlanChange deserialize(JsonParser parser, DeserializationContext context) throws IOException {
            ObjectMapper mapper = (ObjectMapper) parser.getCodec();
            JsonNode node = mapper.readTree(parser);
            JsonNode discriminator = node.get("outcome");
            if (discriminator != null) {
                switch (discriminator.asText()) {
                    case "requires_checkout":
                        return mapper.treeToValue(node, PlanChangeVariant1.class);
                    case "scheduled":
                        return mapper.treeToValue(node, PlanChangeVariant2.class);
                    case "completed":
                        return mapper.treeToValue(node, PlanChangeVariant3.class);
                    default:
                        break;
                }
            }
            return mapper.treeToValue(node, PlanChangeVariant1.class);
        }
    }
}
