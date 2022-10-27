package io.x99.controller;

import io.x99.error.NotFoundException;
import io.x99.model.UserEntity;
import io.x99.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/user")
    List<UserEntity> all() {
        return repository.findAll();
    }

    @GetMapping("/user/{id}")
    UserEntity one(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id is not found"));
    }
}
