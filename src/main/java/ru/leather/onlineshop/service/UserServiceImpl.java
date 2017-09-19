package ru.leather.onlineshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.leather.onlineshop.model.Roles;
import ru.leather.onlineshop.model.User;
import ru.leather.onlineshop.repository.RolesRepository;
import ru.leather.onlineshop.repository.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public User addUser(User user) {
        Set<Roles> roles = new HashSet<>();
        roles.add(rolesRepository.getOne(2));
        user.setRoles(roles);
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.delete(id);
    }

    @Override
    public User getByNameUser(String email) {
        return userRepository.findByName(email);
    }

    @Override
    public User editUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
