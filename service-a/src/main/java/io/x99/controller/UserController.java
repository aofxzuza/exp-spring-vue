package io.x99.controller;

import io.x99.error.ErrorResponse;
import io.x99.error.NotFoundException;
import io.x99.model.UserEntity;
import io.x99.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @GetMapping("/user")
    ResponseEntity<?> all() {
        try {
            List<UserEntity> users = userService.getAllUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Throwable th) {
            LOGGER.error("Internal Error", th);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/{id}")
    ResponseEntity<?> one(@PathVariable Integer id) {
        try {
            UserEntity user = userService.getUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Throwable th) {
            LOGGER.error("Internal Error", th);
            return new ResponseEntity<>(new ErrorResponse("Internal Error"),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
