package com.peeyush.api.repositories;

import com.peeyush.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByName(String name);

    @Query(nativeQuery = true, value = "SELECT * FROM public.users a INNER JOIN public.contacts b ON a.user_id = b.user_id WHERE a.user_id = :userId")
    Optional<User> findByIdNativeQuery(@Param("userId") Integer userId);
    
    //List<User> findByNameAndAge(String name, int age);
}
