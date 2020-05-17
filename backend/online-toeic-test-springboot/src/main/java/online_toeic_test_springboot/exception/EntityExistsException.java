package online_toeic_test_springboot.exception;

public class EntityExistsException extends RuntimeException {
    public EntityExistsException(String errorMessage) {
        super(errorMessage);
    }
}
