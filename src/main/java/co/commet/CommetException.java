package co.commet;

public class CommetException extends RuntimeException {

    private final String code;
    private final Integer statusCode;
    private final Object details;

    public CommetException(String message) {
        this(message, null, null, null);
    }

    public CommetException(String message, String code, Integer statusCode, Object details) {
        super(message);
        this.code = code;
        this.statusCode = statusCode;
        this.details = details;
    }

    public String getCode() {
        return code;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public Object getDetails() {
        return details;
    }
}
