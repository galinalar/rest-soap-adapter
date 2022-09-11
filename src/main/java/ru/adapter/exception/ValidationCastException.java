package ru.adapter.exception;

import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * Custom  exception for validation errors
 */
public class ValidationCastException extends RuntimeException {

    private List<ObjectError> errors;

    /**
     * Creates exception.
     *
     * @param errors list of exception
     */
    public ValidationCastException(List<ObjectError> errors) {
        this.errors = errors;
    }
}
