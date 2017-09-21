package ru.leather.onlineshop.service;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.leather.onlineshop.model.Roles;
import ru.leather.onlineshop.model.User;
import ru.leather.onlineshop.repository.RolesRepository;
import ru.leather.onlineshop.repository.UserRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    static final Logger logger = (Logger) LoggerFactory.getLogger(UserDetailsServiceImpl.class);


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public User addUser(User user) {
        List<Roles> roles = new ArrayList<>();
        LocalDateTime localtime = LocalDateTime.now();
        Timestamp localtimestamp = Timestamp.valueOf(localtime);

        user.setRegistered(localtimestamp);
        roles.add(rolesRepository.findOne(2));
        user.setRoles(roles);
            logger.info("Roles to add default: ", roles.get(0));
        user.setEnable(true);
            logger.info("User field: ", user.toString());
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
