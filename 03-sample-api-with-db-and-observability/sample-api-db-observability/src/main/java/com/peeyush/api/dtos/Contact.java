package com.peeyush.api.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;

import lombok.Value;


@Value
@Builder(toBuilder = true, setterPrefix = "with")
@JsonDeserialize(builder = Contact.ContactBuilder.class)
public class Contact {

    private String phone;
    private String email;

}
