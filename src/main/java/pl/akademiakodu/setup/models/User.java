package pl.akademiakodu.setup.models;

import lombok.*;
import pl.akademiakodu.setup.models.forms.RegisterForm;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Patryk Dudzik on 06.11.2017.
 */

@Data
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String phone;
    private String email;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    @ManyToMany(mappedBy = "eventManager",fetch = FetchType.LAZY)
    private List<EventModel> hostedEvents;

        public User (RegisterForm form) {
        name = form.getName();
        surname = form.getSurname();
        username = form.getUsername();
        password = form.getPassword();
        phone = form.getPhone();
        email = form.getEmail();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
