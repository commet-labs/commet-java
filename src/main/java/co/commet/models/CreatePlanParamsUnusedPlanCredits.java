package co.commet.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;

@JsonDeserialize(using = CreatePlanParamsUnusedPlanCredits.Deserializer.class)
public interface CreatePlanParamsUnusedPlanCredits {
    final class Deserializer extends JsonDeserializer<CreatePlanParamsUnusedPlanCredits> {
        @Override
        public CreatePlanParamsUnusedPlanCredits deserialize(JsonParser parser, DeserializationContext context) throws IOException {
            ObjectMapper mapper = (ObjectMapper) parser.getCodec();
            JsonNode node = mapper.readTree(parser);
            JsonNode discriminator = node.get("type");
            if (discriminator != null) {
                switch (discriminator.asText()) {
                    case "expire":
                        return mapper.treeToValue(node, CreatePlanParamsUnusedPlanCreditsVariant1.class);
                    case "roll_over":
                        return mapper.treeToValue(node, CreatePlanParamsUnusedPlanCreditsVariant2.class);
                    default:
                        break;
                }
            }
            return mapper.treeToValue(node, CreatePlanParamsUnusedPlanCreditsVariant1.class);
        }
    }
}
