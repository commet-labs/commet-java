package co.commet.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.IOException;

@JsonDeserialize(using = TransactionPaymentContextRecovery.Deserializer.class)
public interface TransactionPaymentContextRecovery {
    final class Deserializer extends JsonDeserializer<TransactionPaymentContextRecovery> {
        @Override
        public TransactionPaymentContextRecovery deserialize(JsonParser parser, DeserializationContext context) throws IOException {
            ObjectMapper mapper = (ObjectMapper) parser.getCodec();
            JsonNode node = mapper.readTree(parser);
            JsonNode discriminator = node.get("type");
            if (discriminator != null) {
                switch (discriminator.asText()) {
                    case "payment_recovery":
                        return mapper.treeToValue(node, TransactionPaymentContextRecoveryVariant1.class);
                    case "dunning_retry":
                        return mapper.treeToValue(node, TransactionPaymentContextRecoveryVariant2.class);
                    default:
                        break;
                }
            }
            return mapper.treeToValue(node, TransactionPaymentContextRecoveryVariant1.class);
        }
    }
}
