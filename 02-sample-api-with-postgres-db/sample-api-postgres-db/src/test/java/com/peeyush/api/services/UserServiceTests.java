package com.peeyush.api.services;

import com.github.javafaker.Faker;
import com.peeyush.api.exceptions.NotFoundException;
import com.peeyush.api.models.User;
import com.peeyush.api.repositories.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    UserService sut;

    Faker faker = new Faker();

    @Test
    public void findUserById_success() {
        //Arrange
        var userIdToSearch = faker.number().randomDigitNotZero();
        var user = new User();
        user.setId(userIdToSearch);
        user.setName(faker.lorem().word());
        user.setAge(faker.number().randomDigitNotZero());

        Mockito.when(userRepository.findById(userIdToSearch)).thenReturn(Optional.of(user));

        //Act
        var userSearchResponse = sut.findUserById(userIdToSearch);

        //Assert
        assertThat(Integer.valueOf(userSearchResponse.getId())).isEqualTo(user.getId());
        assertThat(userSearchResponse.getName()).isEqualTo(user.getName());
        assertThat(userSearchResponse.getAge()).isEqualTo(user.getAge());
    }

    @Test
    public void findUserById_NotFound() {
        //Arrange
        var userIdToSearch = faker.number().randomDigitNotZero();

        Mockito.when(userRepository.findById(userIdToSearch)).thenReturn(Optional.empty());

        //Act
        assertThatThrownBy(() -> {
            var userSearchResponse = sut.findUserById(userIdToSearch);
        }).isInstanceOf(NotFoundException.class)
                .hasMessage(String.format("User with id %s not found", userIdToSearch));

    }
}
