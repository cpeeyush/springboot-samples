package com.peeyush.api.dtos;

import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Objects;

/**
 * Represents an API error response.
 */
public class ErrorResponse {

    private final HttpStatus code;
    private final List<String> message;

    public ErrorResponse(HttpStatus code, List<String> message) {
        this.code = code;
        this.message = message;
    }

    public HttpStatus getCode() {
        return code;
    }

    public List<String> getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorResponse that = (ErrorResponse) o;
        return code == that.code && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message);
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "code=" + code +
                ", message=" + message +
                '}';
    }
}
