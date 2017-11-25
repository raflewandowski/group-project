package pl.akademiakodu.setup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.setup.models.Role;

import java.util.List;

/**
 * Created by Patryk Dudzik on 23.11.2017.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findByName (String name);
}
