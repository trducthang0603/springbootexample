package spring_redis.exception;

public class HttpBadRequestException extends RuntimeException {
    public HttpBadRequestException(String msg) {
        super(msg);
    }
}
