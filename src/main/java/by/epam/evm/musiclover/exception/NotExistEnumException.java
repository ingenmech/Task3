package by.epam.evm.musiclover.exception;

public class NotExistEnumException extends Exception {
    public NotExistEnumException() {
    }

    public NotExistEnumException(String message) {
        super(message);
    }

    public NotExistEnumException(String message, Throwable cause) {
        super(message, cause);
    }
}
