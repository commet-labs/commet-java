package co.commet;

public class CommetException extends RuntimeException {

    private final String type;
    private final String code;
    private final Integer statusCode;
    private final Object details;
    private final String param;
    private final String docUrl;

    public CommetException(String message) {
        this(message, null, null, null, null, null, null);
    }

    public CommetException(String message, String code, Integer statusCode, Object details) {
        this(message, null, code, statusCode, details, null, null);
    }

    public CommetException(String message, String type, String code, Integer statusCode,
                           Object details, String param, String docUrl) {
        super(message);
        this.type = type;
        this.code = code;
        this.statusCode = statusCode;
        this.details = details;
        this.param = param;
        this.docUrl = docUrl;
    }

    public String getType() {
        return type;
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

    public String getParam() {
        return param;
    }

    public String getDocUrl() {
        return docUrl;
    }
}
