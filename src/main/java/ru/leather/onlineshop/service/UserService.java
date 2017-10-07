package ru.leather.onlineshop.service;

import ru.leather.onlineshop.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void deleteUser(Integer id);

    User getByNameUser(String email);

    User getByIdUser(Integer id);

    void editUser(User user);

    Integer getByAccount(String email);

    void editPassword(User user);

    List<User> getAll();
}
