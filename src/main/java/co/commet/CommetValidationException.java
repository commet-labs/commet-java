package co.commet;

import java.util.List;
import java.util.Map;

public class CommetValidationException extends CommetException {

    private static final long serialVersionUID = 1L;

    private final transient Map<String, List<String>> validationErrors;

    public CommetValidationException(String message, Map<String, List<String>> validationErrors) {
        this(message, validationErrors, null, null, null, null, null);
    }

    public CommetValidationException(String message, Map<String, List<String>> validationErrors,
                                     Object details, String type, String param, String docUrl,
                                     String requestId) {
        super(message, type, "validation_error", 422, details, param, docUrl, requestId);
        this.validationErrors = validationErrors;
    }

    public Map<String, List<String>> getValidationErrors() {
        return validationErrors;
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> fields = super.toMap();
        fields.put("validationErrors", validationErrors);
        return fields;
    }
}
