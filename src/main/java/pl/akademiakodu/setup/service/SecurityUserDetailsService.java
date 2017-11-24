package pl.akademiakodu.setup.service;

import org.slf4j.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.transaction.annotation.Transactional;
import pl.akademiakodu.setup.models.*;
import pl.akademiakodu.setup.models.User;
import pl.akademiakodu.setup.repository.UserRepository;

import java.util.*;

/**
 * Created by Patryk Dudzik on 24.11.2017.
 */
@Transactional
public class SecurityUserDetailsService implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(SecurityUserDetailsService.class);

    private UserRepository userRepository;

    public SecurityUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            List<User> users = userRepository.findByUsername(username);
            if (users == null) {
                log.debug("user not found with the provided username " + username);
                return null;
            }
            User user = users.get(0);
            log.debug(" user from username " + user.toString());
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                    getAuthorities(user));
        }
        catch (Exception e){
            throw new UsernameNotFoundException("User not found");
        }
    }

    private Set<GrantedAuthority> getAuthorities(User user){
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for(Role role : user.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
            authorities.add(grantedAuthority);
        }
        log.debug("user authorities are " + authorities.toString());
        return authorities;
    }
}
