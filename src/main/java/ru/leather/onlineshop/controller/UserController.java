package ru.leather.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.leather.onlineshop.model.User;
import ru.leather.onlineshop.service.UserService;

import java.security.Principal;
import java.util.Map;
import java.util.Optional;

import static ru.leather.onlineshop.utils.DatabasePasswordEncoder.encode;
import static ru.leather.onlineshop.utils.DatabasePasswordEncoder.isMatch;


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
    public String registration(Map<String,Object> model) {
        model.put("userForm", new User());
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
    public String findUser(Map<String,Object> model, @PathVariable Optional<String> action, Principal principal){
        model.put("objUser", userService.getByNameUser(principal.getName()));
        if (action.isPresent()) {
            switch (action.get()){
                case "edit": return "users/edit";
                case "password": return "users/password";
                case "email": return "users/email";
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

        if(isMatch(oldPassword, encode(userService.getByIdUser(objUser.getId()).getPassword()))) {
            objUser.setPassword(password);
            userService.editPassword(objUser);
        }else{
            bindingResult.rejectValue("password", "error.pass");
            return "users/password";
        }

        return "redirect:/users";
    }

    @RequestMapping(value = "/users/email", method = RequestMethod.POST)
    public String changeEmailUser(@ModelAttribute("objUser") @Validated User objUser,
                                     @RequestParam("oldEmail") String oldEmail,
                                     @RequestParam("email") String email,
                                     BindingResult bindingResult) {

        if(userService.getByIdUser(objUser.getId()).getEmail().contains(oldEmail)) {
            objUser.setEmail(email);
            userService.editEmail(objUser);
        }else{
            bindingResult.rejectValue("email", "error.upemail");
            return "users/email";
        }

        return "redirect:/users";
    }


}
