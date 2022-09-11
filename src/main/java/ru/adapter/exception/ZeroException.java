package ru.adapter.exception;
/**
 * Custom  exception for divide-by-zero error
 */
public class ZeroException extends RuntimeException {

    /**
     * Creates exception.
     *
     * @param message of exception
     */
    public ZeroException(String message) {
        super(message);
    }
}
