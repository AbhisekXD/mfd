package com.cyfrifpro.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

import com.cyfrifpro.payloads.ApiResponse;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class MyGlobalExceptionHandler {

    // Handle ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> myResourceNotFoundException(ResourceNotFoundException e) {
        ApiResponse res = new ApiResponse(false, e.getMessage());
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }

    // Handle APIException
    @ExceptionHandler(APIException.class)
    public ResponseEntity<ApiResponse> myAPIException(APIException e) {
        ApiResponse res = new ApiResponse(false, e.getMessage());
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

    // Handle MethodArgumentNotValidException (validation errors)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> myMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> validationErrors = new HashMap<>();
        
        // Extract field validation errors
        e.getBindingResult().getAllErrors().forEach(err -> {
            String fieldName = ((FieldError) err).getField();  // Get the field name that failed
            String message = err.getDefaultMessage();  // Get the error message
            validationErrors.put(fieldName, message);  // Map the field name to its error message
        });
        
        ApiResponse res = new ApiResponse(false, "Validation errors", validationErrors);
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

    // Handle ConstraintViolationException (for annotations like @NotNull, @Size, etc.)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse> myConstraintsViolationException(ConstraintViolationException e) {
        Map<String, String> violationErrors = new HashMap<>();
        
        // Extract constraint violation errors
        e.getConstraintViolations().forEach(violation -> {
            String fieldName = violation.getPropertyPath().toString();  // Get the violated field name
            String message = violation.getMessage();  // Get the violation message
            violationErrors.put(fieldName, message);  // Add the violation to the map
        });

        ApiResponse res = new ApiResponse(false, "Constraint violation errors", violationErrors);
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

    // Handle AuthenticationException
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiResponse> myAuthenticationException(AuthenticationException e) {
        ApiResponse res = new ApiResponse(false, e.getMessage());
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

    // Handle MissingPathVariableException
    @ExceptionHandler(MissingPathVariableException.class)
    public ResponseEntity<ApiResponse> myMissingPathVariableException(MissingPathVariableException e) {
        ApiResponse res = new ApiResponse(false, e.getMessage());
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

    // Handle DataIntegrityViolationException (usually related to database integrity, like unique constraints)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponse> myDataIntegrityException(DataIntegrityViolationException e) {
        ApiResponse res = new ApiResponse(false, e.getMessage());
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

    // Handle RestClientException (e.g., for external API calls)
    @ExceptionHandler(RestClientException.class)
    public ResponseEntity<ApiResponse> handleRestClientException(RestClientException ex) {
        ApiResponse res = new ApiResponse(false, "Error calling external API: " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
    }

    // Handle unexpected or general exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleException(Exception ex) {
        ApiResponse res = new ApiResponse(false, "An unexpected error occurred: " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
    }
}
