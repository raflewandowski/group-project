package pl.akademiakodu.setup.models.forms;

import lombok.*;

/**
 * Created by Patryk Dudzik on 06.11.2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterForm {

    private String name;
    private String surname;
    private String nickname;
    private String password;
    private String phone;
    private String email;
}
