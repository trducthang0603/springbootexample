package spring_redis.exception;

public class HttpNotFoundException extends RuntimeException {
    public HttpNotFoundException(String msg) {
        super(msg);
    }
}
