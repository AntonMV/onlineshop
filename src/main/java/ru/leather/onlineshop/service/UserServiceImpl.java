package ru.leather.onlineshop.service;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.leather.onlineshop.model.Contacts;
import ru.leather.onlineshop.model.Roles;
import ru.leather.onlineshop.model.User;
import ru.leather.onlineshop.repository.RolesRepository;
import ru.leather.onlineshop.repository.UserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    static final Logger logger = (Logger) LoggerFactory.getLogger(UserDetailsServiceImpl.class);


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

        roles.add(rolesRepository.findByName("ROLE_USER"));

        user.setContact(contacts);

        user.setRoles(roles);
            logger.info("Roles to add default: ", roles.get(0));
        user.setEnable(true);
            logger.info("User field: ", user.toString());

        userRepository.saveAndFlush(user);
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
    @Transactional
    public void editUser(User user) {

          User upuser = userRepository.findOne(user.getId());
          upuser.setContact(user.getContact());
          userRepository.save(upuser);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
