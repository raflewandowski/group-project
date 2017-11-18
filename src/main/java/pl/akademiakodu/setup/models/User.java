package pl.akademiakodu.setup.models;

import lombok.*;
import pl.akademiakodu.setup.models.forms.RegisterForm;

import javax.persistence.*;

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
    private String nickname;
    private String password;
    private String phone;
    private String email;

    public User (RegisterForm form) {
        name = form.getName();
        surname = form.getSurname();
        nickname = form.getNickname();
        password = form.getPassword();
        phone = form.getPhone();
        email = form.getEmail();
    }
}
