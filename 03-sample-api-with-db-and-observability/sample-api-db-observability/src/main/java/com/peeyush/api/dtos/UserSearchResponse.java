package com.peeyush.api.dtos;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Value
@Builder(toBuilder = true, setterPrefix = "with")
@JsonDeserialize(builder = UserSearchResponse.UserSearchResponseBuilder.class)
public class UserSearchResponse {

    private String id;
    private String name;
    private Integer age;
    private List<Contact> contacts;

}
