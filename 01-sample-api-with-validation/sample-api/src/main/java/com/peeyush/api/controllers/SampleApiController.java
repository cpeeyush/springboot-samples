package com.peeyush.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/sample")
public class SampleApiController {

    @GetMapping("/hello/{id}")
    public String sayHello(@PathVariable("id") String id) {
        return "Hello, id is: " + id;
    }

    @GetMapping("/bye/{id}")
    public ResponseEntity<String> sayBye(@PathVariable("id") String id) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("X-Custom-Header", UUID.randomUUID().toString())
                .body("Bye, id is: " + id);
    }
}
