package co.commet.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;

@JsonDeserialize(using = FeatureAccess.Deserializer.class)
public interface FeatureAccess {
    final class Deserializer extends JsonDeserializer<FeatureAccess> {
        @Override
        public FeatureAccess deserialize(JsonParser parser, DeserializationContext context) throws IOException {
            ObjectMapper mapper = (ObjectMapper) parser.getCodec();
            JsonNode node = mapper.readTree(parser);
            JsonNode discriminator = node.get("type");
            if (discriminator != null) {
                switch (discriminator.asText()) {
                    case "boolean":
                        return mapper.treeToValue(node, FeatureAccessVariant1.class);
                    case "usage":
                        return mapper.treeToValue(node, FeatureAccessVariant2.class);
                    case "seats":
                        return mapper.treeToValue(node, FeatureAccessVariant3.class);
                    case "quota":
                        return mapper.treeToValue(node, FeatureAccessVariant4.class);
                    default:
                        break;
                }
            }
            return mapper.treeToValue(node, FeatureAccessVariant1.class);
        }
    }
}
