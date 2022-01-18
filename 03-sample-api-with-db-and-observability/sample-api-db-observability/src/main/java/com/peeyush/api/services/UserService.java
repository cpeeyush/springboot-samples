package com.peeyush.api.services;

import com.peeyush.api.dtos.Contact;
import com.peeyush.api.dtos.UserSearchResponse;
import com.peeyush.api.exceptions.NotFoundException;
import com.peeyush.api.models.User;
import com.peeyush.api.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserSearchResponse findUserById(final Integer userId) {

        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty()) {
            throw new NotFoundException(String.format("User with id %s not found", userId));
        }

        return toUserResponse(optionalUser.get());
    }

    public List<UserSearchResponse> findUserByName(final String name) {

        if (!StringUtils.hasText(name)) {
            throw new IllegalArgumentException("Name must not be blank.");
        }

        /*
            var user = new User();
            user.setName(name);
            var users = userRepository.findAll(Example.of(user, ExampleMatcher.matching().withIgnoreCase()));
        */

        var users = userRepository.findByName(name);

        if(users.isEmpty()) {
            throw new NotFoundException(String.format("User with name %s not found",name));
        }

        return users.stream()
                .map(this::toUserResponse).collect(Collectors.toList());

    }

    private UserSearchResponse toUserResponse(User user) {

        return UserSearchResponse.builder()
                .withId(user.getId().toString())
                .withName(user.getName())
                .withAge(user.getAge())
                .withContacts(user.getContacts()
                        .stream().map(contact -> {
                            return Contact.builder()
                                    .withEmail(contact.getEmail())
                                    .withPhone(contact.getPhone())
                                    .build();
                        }).collect(Collectors.toList()))
                .build();
    }

}
