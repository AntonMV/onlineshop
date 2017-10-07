package ru.leather.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.leather.onlineshop.model.User;
import ru.leather.onlineshop.service.UserService;

import java.util.Optional;

import static ru.leather.onlineshop.utils.DatabasePasswordEncoder.encode;
import static ru.leather.onlineshop.utils.DatabasePasswordEncoder.isMatch;
import static ru.leather.onlineshop.utils.SecurityPrincipal.getUsername;


@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String homePage() {
        return "home";
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
            if (userService.getByAccount(userForm.getEmail()) > 0){
                bindingResult.rejectValue("email", "error.email");
                return "registration";
        }
        userService.addUser(userForm);
        return "redirect:/home";
    }

    @RequestMapping(value = {"/users/{action}","/users"}, method = RequestMethod.GET)
    public String findUser(Model model, @PathVariable Optional<String> action){
        model.addAttribute("objUser", userService.getByNameUser(getUsername()));
        if (action.isPresent()) {
            switch (action.get()){
                case "password": return "users/password";
                case "edit": return "users/edit";
            }
        }
        return "users";
    }

    @RequestMapping(value = "/users/edit", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("objUser") @Validated User objUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/edit";
        }
        userService.editUser(objUser);
        return "redirect:/users";
    }

    @RequestMapping(value = "/users/password", method = RequestMethod.POST)
    public String changePasswordUser(@ModelAttribute("objUser") @Validated User objUser,
                                     @RequestParam("oldPassword") String oldPassword,
                                     @RequestParam("password") String password,
                                     BindingResult bindingResult) {

        if(isMatch(oldPassword, encode(userService.getByIdUser(objUser.getId()).getPassword())) == true) {
            objUser.setPassword(password);
            userService.editPassword(objUser);
        }else{
            bindingResult.rejectValue("password", "error.pass");
            return "users/password";
        }

        return "redirect:/users";
    }


}
