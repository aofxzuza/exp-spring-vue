package io.x99.controller;

import io.x99.error.NotFoundException;
import io.x99.model.entity.TestTableEntity;
import io.x99.repository.TestTableRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestTableController {
    private final TestTableRepository repository;

    TestTableController(TestTableRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/table")
    List<TestTableEntity> all() {
        return repository.findAll();
    }

    @GetMapping("/table/{id}")
    TestTableEntity one(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id is not found"));
    }
}
