package ru.leather.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.leather.onlineshop.service.ProductService;
import ru.leather.onlineshop.service.UserService;

import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "/adminpanel", method = RequestMethod.GET)
    public String login(Map<String, Object> model) {
        model.put("allProduct", productService.getAll());
        return "panel";
    }

    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "/controluser", method = RequestMethod.GET)
    public String controllEditUser(Map<String, Object> model) {
        model.put("allUsers", userService.getAll());
        return "controluser";
    }
}
