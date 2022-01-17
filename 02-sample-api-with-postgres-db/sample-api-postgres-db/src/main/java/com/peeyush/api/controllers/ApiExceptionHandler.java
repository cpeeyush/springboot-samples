package com.peeyush.api.controllers;

import com.peeyush.api.dtos.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice(assignableTypes = {UserController.class})
public class ApiExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ApiExceptionHandler.class);

    /**
     * Handler for spring BindException
     *
     * @param exception see {@link BindException}
     * @return see {@link ErrorResponse}
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorResponse> handleBindException(final BindException exception) {

        final List<String> errors = exception.getBindingResult().getFieldErrors()
                .stream()
                .map(e -> e.getField() + ":" + e.getDefaultMessage())
                .collect(Collectors.toList());

        var errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, errors);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    /**
     * Catcher for all unhandled exceptions
     *
     * @param exception see {@link Exception}
     * @return see {@link ErrorResponse}
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAll(final Exception exception) {
        log.error(exception.getClass().getName(), exception);
        var errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, List.of("Error Occurred"));
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponse);
    }
}
