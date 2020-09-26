package by.epam.evm.musiclover.exception;

import java.io.FileNotFoundException;

public class DataException extends Throwable {
    public DataException() {

    }

    public DataException(String message, Throwable exception) {
        super(message, exception);
    }
}
