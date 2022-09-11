package ru.adapter.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * This @code{AdapterExceptionHandler} class handles exceptions.
 */

@ControllerAdvice
public class AdapterExceptionHandler {

    private static final Logger LOGGER = LogManager.getLogger(AdapterExceptionHandler.class);
    private static final String VALIDATOR = "Check the spelling of the parameter";
    private static final String SOAP = "Internal Server Error";
    private static final String ZERO = "Can't divide by zero";

    /**
     * Handles validation exceptions.
     *
     * @param e - exception thrown.
     * @return response entity with error code
     */
    @ExceptionHandler(ValidationCastException.class)
    public ResponseEntity<String> handleValidationException(Exception e) {
        LOGGER.error("Validation error", e);

        return new ResponseEntity<>(VALIDATOR, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles SOAP response exception.
     *
     * @param e - exception thrown.
     * @return response entity with error code
     */
    @ExceptionHandler(SoapResultException.class)
    public ResponseEntity<String> handleSoapResultException(Exception e) {
        LOGGER.error("Server response error", e);

        return new ResponseEntity<>(SOAP, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    /**
     * Handles divide-by-zero error.
     *
     * @param e - exception thrown.
     * @return response entity with error code
     */
    @ExceptionHandler(ZeroException.class)
    public ResponseEntity<String> handleZeroException(Exception e) {
        LOGGER.error("Divide by zero", e);

        return new ResponseEntity<>(ZERO, HttpStatus.BAD_REQUEST);
    }
}
