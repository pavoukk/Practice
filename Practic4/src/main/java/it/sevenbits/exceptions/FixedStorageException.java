package it.sevenbits.exceptions;

public class FixedStorageException extends Exception {
    public FixedStorageException() {
        super();
    }

    public FixedStorageException(String message) {
        super(message);
    }

    public FixedStorageException(String message, Throwable cause) {
        super(message, cause);
    }

    public FixedStorageException(Throwable cause) {
        super(cause);
    }
}
