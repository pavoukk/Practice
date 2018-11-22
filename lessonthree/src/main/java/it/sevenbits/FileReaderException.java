package it.sevenbits;

import java.io.IOException;

/**
 * The exception class
 */
public class FileReaderException extends IOException {

    /**
     * The constructor
     * @param message error message
     */
    FileReaderException(final String message) {
        super(message);
    }

    /**
     * The constructor
     * @param message error message
     * @param cause error cause
     */
    FileReaderException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * The constructor
     * @param cause error cause
     */
    FileReaderException(final Throwable cause) {
        super(cause);
    }
}
