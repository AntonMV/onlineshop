package ru.leather.onlineshop.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.leather.onlineshop.model.User;
import ru.leather.onlineshop.service.UserService;
import java.util.List;


@RestController
@RequestMapping(value = "/rest/user")
public class UserRestAjaxController {

    final Logger logger = LoggerFactory.getLogger(UserRestAjaxController.class);

    @Autowired
    private UserService userService;

    @GetMapping(value="/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(@PathVariable("id") int id) {
        return userService.getByIdUser(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id) {
        logger.info("Delete user: " + userService.getByIdUser(id));
        userService.deleteUser(id);
    }

    @PostMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User create(@RequestBody User user) {
        logger.info("Creating user: " + user);
        userService.addUser(user);
        logger.info("User created successfully with info: " + user);
        return user;
    }

    @PutMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void update(@RequestBody User user,
                       @PathVariable Integer id) {
        logger.info("Updating user: " + user);
        userService.editUser(user);
        logger.info("User updated successfully with info: " + user);
    }

}
