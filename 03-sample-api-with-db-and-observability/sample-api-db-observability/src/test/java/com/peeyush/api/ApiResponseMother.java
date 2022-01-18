package com.peeyush.api;

import com.peeyush.api.dtos.Contact;
import com.peeyush.api.dtos.UserSearchResponse;

import java.util.List;

public class ApiResponseMother {

    public UserSearchResponse sampleUserSearchResponse() {
        var contact1 = Contact.builder()
                .withEmail("peeyush@example.com")
                .withPhone("+0000000006")
                .build();


        var contact2 = Contact.builder()
                .withEmail("peeyush2@example.com")
                .withPhone("+0000000007")
                .build();

        var userSearchResponse = UserSearchResponse.builder()
                .withId("6")
                .withName("Peeyush")
                .withAge(24)
                .withContacts(List.of(contact1, contact2))
                .build();


        return userSearchResponse;
    }

}
