package pl.akademiakodu.setup.models.forms;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

import javax.validation.constraints.*;

/**
 * Created by Patryk Dudzik on 06.11.2017.
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterForm {

    @NotBlank
    @Size(min = 3, max = 40)
    private String name;
    @NotBlank
    @Size(min = 3, max = 40)
    private String surname;
    @NotBlank
    @Size(min = 3, max = 40)
    private String username;
    @NotBlank
    @Size(min = 3, max = 80)
    private String password;
    @Pattern(regexp = "[0-9]{9,30}", message = "invalid number lenght")
    private String phone;
    @NotBlank
    @Size(min = 3, max = 40)
    private String email;
}
