package pl.akademiakodu.setup.models.forms;

import lombok.*;

/**
 * Created by Patryk Dudzik on 03.11.2017.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginForm {
    private String username;
    private String password;
}
