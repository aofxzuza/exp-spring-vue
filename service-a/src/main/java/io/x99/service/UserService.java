package io.x99.service;

import io.x99.error.NotFoundException;
import io.x99.model.UserEntity;
import io.x99.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        LOGGER.debug("Get all users");
        Iterable<UserEntity> iterable = userRepository.findAll();
        return Streamable.of(iterable).toList();
    }

    public UserEntity getUserById(Long id) {
        LOGGER.debug("Get user by id {}", id);
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id is not found"));
    }
}
