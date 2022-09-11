package ru.adapter.exception;

/**
 * Custom  exception for SOAP result error.
 */
public class SoapResultException extends RuntimeException {

    /**
     * Creates exception.
     *
     * @param message of exception
     */
    public SoapResultException(String message) {
        super(message);
    }
}
