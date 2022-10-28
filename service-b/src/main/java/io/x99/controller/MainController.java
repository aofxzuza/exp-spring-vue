package io.x99.controller;

import io.x99.model.User;
import io.x99.service.ServiceAClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private ServiceAClient client;

    @GetMapping("/")
    public String index(Model model) {
        List<User> users = client.getUsers();
        model.addAttribute("users", users);
        return "index";
    }
}
