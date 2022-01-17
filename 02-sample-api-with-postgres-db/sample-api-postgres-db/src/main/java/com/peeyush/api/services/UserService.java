package com.peeyush.api.services;

import com.peeyush.api.dtos.UserRequest;
import com.peeyush.api.dtos.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    public List<UserResponse> find(final UserRequest userRequest) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(UUID.randomUUID().toString());
        userResponse.setName("Peeyush");
        userResponse.setAge(300);

        return List.of(userResponse);
    }

}
