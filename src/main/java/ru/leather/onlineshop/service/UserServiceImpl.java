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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
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
    public void addUser(User user) {
        List<Roles> roles = new ArrayList<>();

        user.setRegistered(LocalDate.now());

        roles.add(rolesRepository.findOne(2));

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
    public void editUser(User user) {

        userRepository.updateEmail(user.getId(),user.getName(), user.getAddress(),
                                   user.getPhone(),user.getBirthday());

//          User userup = userRepository.getOne(user.getId());
//          userup.setName(user.getName());
//          userup.setAddress(user.getAddress());
//          userup.setPhone(user.getPhone());
//          userup.setBirthday(user.getBirthday());
//
//          userRepository.save(userup);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
