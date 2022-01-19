package com.peeyush.api;

import com.peeyush.api.dtos.Contact;
import com.peeyush.api.dtos.ErrorResponse;
import com.peeyush.api.dtos.UserSearchResponse;
import org.springframework.http.HttpStatus;

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

    public ErrorResponse userNotFound(int userId) {

        var errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, List.of(String.format("User with id %d not found", userId)));

        return errorResponse;
    }

}
