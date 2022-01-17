package com.peeyush.api.controllers;

import com.peeyush.api.dtos.UserRequest;
import com.peeyush.api.dtos.UserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

/**
 * A sample controller for the User resource.
 */
@RestController
@RequestMapping("/api/v1")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/users")
    public List<UserResponse> getUsers(final @Valid UserRequest userRequest) {

        log.info("UserRequest: {}", userRequest);

        UserResponse userResponse = new UserResponse();
        userResponse.setId(UUID.randomUUID().toString());
        userResponse.setName("Peeyush");
        userResponse.setAge(300);

        return List.of(userResponse);
    }

}
