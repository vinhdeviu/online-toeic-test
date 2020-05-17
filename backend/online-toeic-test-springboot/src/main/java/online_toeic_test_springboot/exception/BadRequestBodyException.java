package online_toeic_test_springboot.exception;

public class BadRequestBodyException extends RuntimeException {
    public BadRequestBodyException(String errorMessage) {
        super(errorMessage);
    }
}
