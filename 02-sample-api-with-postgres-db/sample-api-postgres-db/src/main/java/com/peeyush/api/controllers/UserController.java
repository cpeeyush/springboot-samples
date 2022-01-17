package com.peeyush.api.controllers;

import com.peeyush.api.dtos.UserRequest;
import com.peeyush.api.dtos.UserResponse;
import com.peeyush.api.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * A sample controller for the User resource.
 */
@RestController
@RequestMapping("/api/v1")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

//    @Autowired - Field level injection discouraged generally but still works.
//    private UserService userService;

    private final UserService userService;

    // @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserResponse> getUsers(final @Valid UserRequest userRequest) {

        log.info("UserRequest: {}", userRequest);

        return userService.find(userRequest);
    }

}
