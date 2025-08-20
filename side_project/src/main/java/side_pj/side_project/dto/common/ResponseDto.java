package side_pj.side_project.dto.common;

public class ResponseDto<T> {
    private final int status;
    private final String message;
    private final T data;

    // 생성자
    public ResponseDto(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    // static 헬퍼 메서드
    public static <T> ResponseDto<T> success(T data) {
        return new ResponseDto<>(200, "요청 성공", data);
    }

    public static <T> ResponseDto<T> fail(int i, String message) {
        return new ResponseDto<>(400, message, null);
    }

    // Getter
    public int getStatus() { return status; }
    public String getMessage() { return message; }
    public T getData() { return data; }
}
