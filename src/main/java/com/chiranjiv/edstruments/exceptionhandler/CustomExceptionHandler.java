package com.chiranjiv.edstruments.exceptionhandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;


/**
 * Global exception handler for the application.
 * Handles specific exceptions and provides custom error responses.
 */
@ControllerAdvice
public class CustomExceptionHandler {
	
	
	
    /**
     * Handles ProductNotFoundException.
     * This exception is thrown when a requested product cannot be found.
     *
     * @param ex the ProductNotFoundException instance containing the exception details.
     * @return a ResponseEntity containing an error message and a NOT_FOUND (404) status.
     */
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException ex) {
    	// Prepare the response body with a custom error message
        Map<String, String> body = new HashMap<String, String>();
        body.put("message", ex.getMessage());
        
        // Return a 404 NOT_FOUND response with the error details
        return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND);
    }
	
	
    /**
     * Handles ValidationException.
     * This exception is thrown when validation on a method argument annotated with @Valid fails.
     *
     * @param ex the ValidationException instance containing validation errors.
     * @return a ResponseEntity containing field-specific validation errors and a BAD_REQUEST (400) status.
     */
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleValidationException(ValidationException ex) {
        Map<String, String> body = new HashMap<>();
        body.put("message", ex.getMessage());
        
     // Return a 400 BAD_REQUEST response with the validation error details
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    
}
