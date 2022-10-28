package io.x99.controller;

import io.x99.model.User;
import io.x99.service.ServiceAClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private ServiceAClient client;


    @GetMapping("/user")
    List<User> all() {
        return client.getUsers();
    }

    @GetMapping("/user/{id}")
    User one(@PathVariable Integer id) {
        return client.getUser(id);
    }
}
