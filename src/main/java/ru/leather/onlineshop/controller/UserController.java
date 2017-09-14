package ru.leather.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.leather.onlineshop.service.UserService;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users")
    public String listProduct(Map<String, Object> model){
        model.put("allUsers", userService.getAll());
        return "users";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

}
