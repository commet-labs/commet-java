package co.commet;

public class ApiResponse {

    private final boolean success;
    private final Object data;
    private final String code;
    private final String message;
    private final Boolean hasMore;
    private final String nextCursor;

    public ApiResponse(boolean success, Object data, String code, String message,
                       Boolean hasMore, String nextCursor) {
        this.success = success;
        this.data = data;
        this.code = code;
        this.message = message;
        this.hasMore = hasMore;
        this.nextCursor = nextCursor;
    }

    public boolean isSuccess() {
        return success;
    }

    public Object getData() {
        return data;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public String getNextCursor() {
        return nextCursor;
    }
}
