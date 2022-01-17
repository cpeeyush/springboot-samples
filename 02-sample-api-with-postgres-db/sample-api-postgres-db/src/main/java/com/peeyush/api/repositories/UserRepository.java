package com.peeyush.api.repositories;

import com.peeyush.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByName(String name);

    //List<User> findByNameAndAge(String name, int age);
}
