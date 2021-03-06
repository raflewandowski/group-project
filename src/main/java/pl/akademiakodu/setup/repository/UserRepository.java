package pl.akademiakodu.setup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.setup.models.User;

import java.util.List;

/**
 * Created by Patryk Dudzik on 09.11.2017.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsername(String username);
    List<User> findByEmail(String email);
}
