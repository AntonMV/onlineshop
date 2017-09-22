package ru.leather.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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


//    @RequestMapping(value = "/users", method = RequestMethod.GET)
//    public String findUser(@RequestParam("email") String email, Model model){
//        model.addAttribute("objUser", userService.getByNameUser(email));
//        return "users";
//    }

//    @RequestMapping(value = "/users", method = RequestMethod.GET)
//    public String findUser(@AuthenticationPrincipal User user, Model model){
//        System.out.printf(":::!!!!"+user.toString());
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        if (principal instanceof UserDetails) {
//            String username = ((UserDetails)principal).getUsername();
//            System.out.printf(":::>>>"+username);
//        } else {
//            String username = principal.toString();
//            System.out.printf(":::>>>"+username);
//        }
////        model.addAttribute("objUser", userService.getByNameUser(user.getEmail()));
//        return "users";
//    }

    @RequestMapping("/users")
    public String findMessagesForUser(@AuthenticationPrincipal JpaUserDetails user, Model model) {
        model.addAttribute("objUser", userService.getByNameUser(user.getEmail()));
        System.out.printf(":::>>>"+user.getName()+" "+user.getEmail());
        return "users";
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
    public String registration(@ModelAttribute("userForm")@Validated User userForm , BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.addUser(userForm);
        return "redirect:/index";
    }
}
