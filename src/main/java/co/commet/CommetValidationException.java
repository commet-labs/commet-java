package co.commet;

import java.util.List;
import java.util.Map;

public class CommetValidationException extends CommetException {

    private final Map<String, List<String>> validationErrors;

    public CommetValidationException(String message, Map<String, List<String>> validationErrors) {
        super(message);
        this.validationErrors = validationErrors;
    }

    public Map<String, List<String>> getValidationErrors() {
        return validationErrors;
    }
}
