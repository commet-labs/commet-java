package co.commet.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;

@JsonDeserialize(using = PreviewChangeOfferApplicationPhasesItem.Deserializer.class)
public interface PreviewChangeOfferApplicationPhasesItem {
    final class Deserializer extends JsonDeserializer<PreviewChangeOfferApplicationPhasesItem> {
        @Override
        public PreviewChangeOfferApplicationPhasesItem deserialize(JsonParser parser, DeserializationContext context) throws IOException {
            ObjectMapper mapper = (ObjectMapper) parser.getCodec();
            JsonNode node = mapper.readTree(parser);
            JsonNode discriminator = node.get("type");
            if (discriminator != null) {
                switch (discriminator.asText()) {
                    case "percentage":
                        return mapper.treeToValue(node, PreviewChangeOfferApplicationPhasesItemVariant1.class);
                    case "amount_off":
                        return mapper.treeToValue(node, PreviewChangeOfferApplicationPhasesItemVariant2.class);
                    case "fixed_price":
                        return mapper.treeToValue(node, PreviewChangeOfferApplicationPhasesItemVariant3.class);
                    default:
                        break;
                }
            }
            return mapper.treeToValue(node, PreviewChangeOfferApplicationPhasesItemVariant1.class);
        }
    }
}
