package it.sevenbits.exceptions;

public class UniqueStorageException extends Exception {
    public UniqueStorageException() {
        super();
    }

    public UniqueStorageException(String message) {
        super(message);
    }

    public UniqueStorageException(String message, Throwable cause) {
        super(message, cause);
    }

    public UniqueStorageException(Throwable cause) {
        super(cause);
    }
}
