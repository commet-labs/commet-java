package co.commet;

public class ApiResponse<T> {

    private final boolean success;
    private final T data;
    private final String code;
    private final String message;
    private final Boolean hasMore;
    private final String nextCursor;

    public ApiResponse(boolean success, T data, String code, String message,
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

    public T getData() {
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
