package io.x99.service;

import io.x99.model.TestTable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "serviceA", url = "http://localhost:8081")
public interface ServiceAClient {

    @RequestMapping(method = RequestMethod.GET, value = "/table")
    List<TestTable> getTables();

    @RequestMapping(method = RequestMethod.GET, value = "/table/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    TestTable getTable(@PathVariable int id);
}
