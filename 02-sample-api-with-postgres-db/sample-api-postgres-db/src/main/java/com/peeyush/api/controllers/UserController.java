package com.peeyush.api.controllers;

import com.peeyush.api.dtos.UserSearchResponse;
import com.peeyush.api.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * A sample controller for the User resource.
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

//    @Autowired - Field level injection discouraged generally but still works.
//    private UserService userService;

    private final UserService userService;

    // @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserSearchResponse getUsersById(@PathVariable("id") final int userId) {

        return userService.findUserById(userId);
    }

    @GetMapping("/name/{name}")
    public List<UserSearchResponse> getUsersByName(@PathVariable("name") @NotEmpty final String name) {

        return userService.findUserByName(name);
    }

}
