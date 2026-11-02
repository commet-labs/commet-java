package co.commet.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;

@JsonDeserialize(using = UpdatePlanParamsUnusedPlanCredits.Deserializer.class)
public interface UpdatePlanParamsUnusedPlanCredits {
    final class Deserializer extends JsonDeserializer<UpdatePlanParamsUnusedPlanCredits> {
        @Override
        public UpdatePlanParamsUnusedPlanCredits deserialize(JsonParser parser, DeserializationContext context) throws IOException {
            ObjectMapper mapper = (ObjectMapper) parser.getCodec();
            JsonNode node = mapper.readTree(parser);
            JsonNode discriminator = node.get("type");
            if (discriminator != null) {
                switch (discriminator.asText()) {
                    case "expire":
                        return mapper.treeToValue(node, UpdatePlanParamsUnusedPlanCreditsVariant1.class);
                    case "roll_over":
                        return mapper.treeToValue(node, UpdatePlanParamsUnusedPlanCreditsVariant2.class);
                    default:
                        break;
                }
            }
            return mapper.treeToValue(node, UpdatePlanParamsUnusedPlanCreditsVariant1.class);
        }
    }
}
