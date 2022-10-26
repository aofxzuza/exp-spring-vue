package io.x99.controller;

import io.x99.model.TestTable;
import io.x99.service.ServiceAClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TableController {
    private final ServiceAClient client;

    TableController(ServiceAClient client) {
        this.client = client;
    }


    @GetMapping("/table")
    List<TestTable> all() {
        return client.getTables();
    }

    @GetMapping("/table/{id}")
    TestTable one(@PathVariable Integer id) {
        return client.getTable(id);
    }
}
