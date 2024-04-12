package com.wissen.meter.Meter.errorHandlers;

import com.wissen.meter.Meter.ResponseBodies.ErrorResponse;
import com.wissen.meter.Meter.customExceptions.CustomerNotFoundException;
import com.wissen.meter.Meter.customExceptions.MeterRecordAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MeterExceptionHandlers {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCustomerNotFoundException(
            CustomerNotFoundException exception
    ) {
        String errorMessage = exception.getMessage();
        ErrorResponse error = ErrorResponse.builder()
                .errorMessage(errorMessage)
                .status(HttpStatus.UNAUTHORIZED)
                .build();
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(MeterRecordAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleMeterRecordAlreadyExistsException(
            MeterRecordAlreadyExistsException exception
    ) {
        String errorMessage = exception.getMessage();
        ErrorResponse error = ErrorResponse.builder()
                .errorMessage(errorMessage)
                .status(HttpStatus.CONFLICT)
                .build();
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}
