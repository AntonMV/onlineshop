package ru.leather.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.leather.onlineshop.model.User;
import ru.leather.onlineshop.service.UserService;


@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = {"/" , "/index"}, method = RequestMethod.GET)
    public String Home() {
        return "index";
    }

    

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm")@Validated User userForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.addUser(userForm);
        return "redirect:/index";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String findUser(Model model){

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = null;
        if (principal instanceof UserDetails) {
            email = ((UserDetails)principal).getUsername();
        }
        model.addAttribute("objUser", userService.getByNameUser(email));
        return "users";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("objUser") @Validated User objUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users";
        }
        userService.editUser(objUser);
        return "redirect:/users";
    }
}
