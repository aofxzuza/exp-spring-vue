package io.x99.service_b.service;

import io.x99.service_b.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "serviceA", url = "${service-a.url}")
public interface ServiceAClient {

    @RequestMapping(method = RequestMethod.GET, value = "/user")
    List<User> getUsers();

    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
    User getUser(@PathVariable int id);

}
