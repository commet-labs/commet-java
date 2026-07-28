package co.commet.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;

@JsonDeserialize(using = PayoutVerification.Deserializer.class)
public interface PayoutVerification {
    final class Deserializer extends JsonDeserializer<PayoutVerification> {
        @Override
        public PayoutVerification deserialize(JsonParser parser, DeserializationContext context) throws IOException {
            ObjectMapper mapper = (ObjectMapper) parser.getCodec();
            JsonNode node = mapper.readTree(parser);
            JsonNode discriminator = node.get("outcome");
            if (discriminator != null) {
                switch (discriminator.asText()) {
                    case "existing":
                        return mapper.treeToValue(node, PayoutVerificationVariant1.class);
                    case "created":
                        return mapper.treeToValue(node, PayoutVerificationVariant2.class);
                    default:
                        break;
                }
            }
            return mapper.treeToValue(node, PayoutVerificationVariant1.class);
        }
    }
}
