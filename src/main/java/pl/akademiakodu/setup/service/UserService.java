package pl.akademiakodu.setup.service;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.akademiakodu.setup.models.User;
import pl.akademiakodu.setup.repository.*;

import java.util.List;

/**
 * Created by Patryk Dudzik on 06.11.2017.
 */

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    public List<User> findByNickname(String nickname) {
        log.info("finding user by nickname={}", nickname);
        return userRepository.findByNickname(nickname);
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
        userRepository.save(user);
        log.info("added user={}", user);
    }

    public Iterable<User> findAll() {
        log.info("finding all users");
        return userRepository.findAll();
    }
}
