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

//    @PersistenceContext
//    private EntityManager em;

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
    }

//    @Override
//    public void editUser(User user) {
//        if (Integer.valueOf(user.getId()) == null) {
//            userRepository.save(user);
//            em.persist(user);
//        } else {
//            em.merge(user);
//        }
//    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
