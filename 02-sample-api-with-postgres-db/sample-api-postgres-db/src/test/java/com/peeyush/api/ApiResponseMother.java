package com.peeyush.api;

import com.peeyush.api.dtos.Contact;
import com.peeyush.api.dtos.UserSearchResponse;

import java.util.List;

public class ApiResponseMother {

    public UserSearchResponse sampleUserSearchResponse() {
        var contact1 = new Contact();
        contact1.setPhone("+0000000006");
        contact1.setEmail("peeyush@example.com");

        var contact2 = new Contact();
        contact2.setPhone("+0000000007");
        contact2.setEmail("peeyush2@example.com");

        var userSearchResponse = new UserSearchResponse();
        userSearchResponse.setId("6");
        userSearchResponse.setName("Peeyush");
        userSearchResponse.setAge(24);
        userSearchResponse.setContacts(List.of(contact1, contact2));

        return userSearchResponse;
    }

}
