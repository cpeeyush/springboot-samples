package com.peeyush.api.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Objects;

/**
 * Represents an API error response.
 */
@Value
@Builder(toBuilder = true, setterPrefix = "with")
@JsonDeserialize(builder = ErrorResponse.ErrorResponseBuilder.class)
public class ErrorResponse {

    private final HttpStatus code;
    private final List<String> message;

}
