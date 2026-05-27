package co.commet;

public class CommetApiException extends CommetException {

    public CommetApiException(String message, int statusCode) {
        this(message, statusCode, null, null, null, null, null);
    }

    public CommetApiException(String message, int statusCode, String code, Object details) {
        this(message, statusCode, code, details, null, null, null);
    }

    public CommetApiException(String message, int statusCode, String code, Object details,
                              String type, String param, String docUrl) {
        super(message, type, code, statusCode, details, param, docUrl);
    }
}
