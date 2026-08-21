package co.commet;

import java.util.LinkedHashMap;
import java.util.Map;

public class CommetException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String type;
    private final String code;
    private final Integer statusCode;
    private final transient Object details;
    private final String param;
    private final String docUrl;
    private final String requestId;

    public CommetException(String message) {
        this(message, null, null, null, null, null, null);
    }

    public CommetException(String message, String code, Integer statusCode, Object details) {
        this(message, null, code, statusCode, details, null, null);
    }

    public CommetException(String message, String type, String code, Integer statusCode,
                           Object details, String param, String docUrl) {
        this(message, type, code, statusCode, details, param, docUrl, null);
    }

    public CommetException(String message, String type, String code, Integer statusCode,
                           Object details, String param, String docUrl, String requestId) {
        super(message);
        this.type = type;
        this.code = code;
        this.statusCode = statusCode;
        this.details = details;
        this.param = param;
        this.docUrl = docUrl;
        this.requestId = requestId;
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

    public String getRequestId() {
        return requestId;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> fields = new LinkedHashMap<>();
        fields.put("message", getMessage());
        fields.put("type", type);
        fields.put("code", code);
        fields.put("statusCode", statusCode);
        fields.put("param", param);
        fields.put("details", details);
        fields.put("requestId", requestId);
        fields.put("docUrl", docUrl);
        return fields;
    }
}
