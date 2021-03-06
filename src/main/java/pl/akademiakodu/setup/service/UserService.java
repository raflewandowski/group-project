package pl.akademiakodu.setup.service;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.akademiakodu.setup.models.User;
import pl.akademiakodu.setup.repository.*;

import java.util.*;

/**
 * Created by Patryk Dudzik on 06.11.2017.
 */

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public List<User> findByUsername(String username) {
        log.info("finding user by username={}", username);
        return userRepository.findByUsername(username);
    }

    public List<User> findByEmail(String email) {
        log.info("finding user by email={}", email);
        return userRepository.findByEmail(email);
    }

    public User findOne(Long id) {
        log.info("finding user with id={}", id);
        return userRepository.findOne(id);
    }

    public void save(User user) {
        log.info("adding user={}", user);
        user.setRoles(roleRepository.findByName("USER"));
        userRepository.save(user);
        log.info("added user={}", user);
    }

    public Iterable<User> findAll() {
        log.info("finding all users");
        return userRepository.findAll();
    }
}
