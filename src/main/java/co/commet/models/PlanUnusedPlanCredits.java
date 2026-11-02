package co.commet.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;

@JsonDeserialize(using = PlanUnusedPlanCredits.Deserializer.class)
public interface PlanUnusedPlanCredits {
    final class Deserializer extends JsonDeserializer<PlanUnusedPlanCredits> {
        @Override
        public PlanUnusedPlanCredits deserialize(JsonParser parser, DeserializationContext context) throws IOException {
            ObjectMapper mapper = (ObjectMapper) parser.getCodec();
            JsonNode node = mapper.readTree(parser);
            JsonNode discriminator = node.get("type");
            if (discriminator != null) {
                switch (discriminator.asText()) {
                    case "expire":
                        return mapper.treeToValue(node, PlanUnusedPlanCreditsVariant1.class);
                    case "roll_over":
                        return mapper.treeToValue(node, PlanUnusedPlanCreditsVariant2.class);
                    default:
                        break;
                }
            }
            return mapper.treeToValue(node, PlanUnusedPlanCreditsVariant1.class);
        }
    }
}
