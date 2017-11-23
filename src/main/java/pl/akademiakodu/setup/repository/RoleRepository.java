package pl.akademiakodu.setup.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.setup.models.Role;

import java.util.Set;

/**
 * Created by Patryk Dudzik on 23.11.2017.
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Set<Role> findByRole (String role);
}
