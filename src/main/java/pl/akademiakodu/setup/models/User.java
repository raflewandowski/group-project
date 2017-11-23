package pl.akademiakodu.setup.models;

import lombok.*;
import pl.akademiakodu.setup.models.forms.RegisterForm;

import javax.persistence.*;
import java.util.List;

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
}
