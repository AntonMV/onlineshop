package ru.leather.onlineshop.service;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.leather.onlineshop.model.Contacts;
import ru.leather.onlineshop.model.Roles;
import ru.leather.onlineshop.model.User;
import ru.leather.onlineshop.repository.RolesRepository;
import ru.leather.onlineshop.repository.UserRepository;
import ru.leather.onlineshop.utils.ArbitraryResourceLoader;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static ru.leather.onlineshop.utils.DatabasePasswordEncoder.encode;


@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    @Transactional
    public void addUser(User user) {
        List<Roles> roles = new ArrayList<>();
        Contacts contacts = new Contacts();
        user.setRegistered(LocalDate.now());
        user.setEmail(user.getEmail().toLowerCase());
        user.setPassword(encode(user.getPassword()));
        roles.add(rolesRepository.findByName("ROLE_USER"));
        user.setContact(contacts);
        user.setRoles(roles);
        user.setEnable(true);
            logger.info("User add: ", user.getEmail());
        userRepository.saveAndFlush(user);
    }

    @Override
    @Transactional
    public void editUser(User user) {
        User upuser = getByIdUser(user.getId());
        upuser.setContact(user.getContact());
            logger.info("Update fields user: ", upuser.getEmail());
        userRepository.save(upuser);
    }

    @Override
    public void editPassword(User user) {
        User passuser = getByIdUser(user.getId());
        passuser.setPassword(encode(user.getPassword()));
            logger.info("Update password user: ", passuser.getEmail());
        userRepository.save(passuser);
    }

    @Override
    @Transactional
    public void editEmail(User user) {
        User eduser = getByIdUser(user.getId());
        eduser.setEmail(user.getEmail());
        logger.info("Update email user: ", eduser.getEmail());
        userRepository.save(eduser);
    }

    @Override
    @Transactional
    public void addUserAvatar(User user, String path) {
        User avuser = getByIdUser(user.getId());
        avuser.getContact().setAvatar(path);
        logger.info("Add avatar for user: ", avuser.getContact().getAvatar().toString());
        userRepository.save(avuser);
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
    public Integer getByAccount(String email) {
        return userRepository.countFindAccount(email);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getByIdUser(Integer id) { return userRepository.findOne(id); }
}
