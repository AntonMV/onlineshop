package ru.leather.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.leather.onlineshop.model.User;
import ru.leather.onlineshop.service.UserService;

import static ru.leather.onlineshop.utils.DatabasePasswordEncoder.encode;
import static ru.leather.onlineshop.utils.DatabasePasswordEncoder.isMatch;
import static ru.leather.onlineshop.utils.SecurityPrincipal.getUsername;


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
            if (userService.getByAccount(userForm.getEmail()) > 0){
                bindingResult.rejectValue("email", "error.email");
                return "registration";
        }
        userService.addUser(userForm);
        return "redirect:/index";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String findUser(Model model){
        model.addAttribute("objUser", userService.getByNameUser(getUsername()));
        return "profile/users";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("objUser") @Validated User objUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "profile/users";
        }
        userService.editUser(objUser);
        return "profile/users";
    }

    @RequestMapping(value = "/users/changepassword", method = RequestMethod.POST)
    public String changePasswordUser(@ModelAttribute("objUser") @Validated User objUser,
                                     @RequestParam("oldPassword") String oldPassword,
                                     @RequestParam("password") String password,
                                     BindingResult bindingResult) {
        System.out.println(isMatch(oldPassword, encode(userService.getByNameUser(objUser.getEmail()).getPassword())));

        if(isMatch(oldPassword, encode(userService.getByNameUser(objUser.getEmail()).getPassword())) == true) {
            objUser.setPassword(password);
            userService.changePasswod(objUser);
        }else{
            bindingResult.rejectValue("password", "error.pass");
            return "profile/users";
        }

        return "profile/users";
    }


}
