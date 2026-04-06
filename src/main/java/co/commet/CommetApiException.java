package co.commet;

public class CommetApiException extends CommetException {

    public CommetApiException(String message, int statusCode) {
        this(message, statusCode, null, null);
    }

    public CommetApiException(String message, int statusCode, String code, Object details) {
        super(message, code, statusCode, details);
    }
}
