package online_toeic_test_springboot.exception;

public class PartIdNotImplementedException extends RuntimeException {
    public PartIdNotImplementedException(String errorMessage) {
        super(errorMessage);
    }
}
