package org.example.back_end.exceptions;

import org.example.back_end.util.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // handle all the exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse<String>>
    handleGenericException(Exception ex){
        return new ResponseEntity<>(new APIResponse<>(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error Occurred",
                null)
                ,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<APIResponse<String>>
    handleResourceNotFound(ResourceNotFound ex){
        return new ResponseEntity<>(new APIResponse<>(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                null
        ),HttpStatus.NOT_FOUND);
    }
}
