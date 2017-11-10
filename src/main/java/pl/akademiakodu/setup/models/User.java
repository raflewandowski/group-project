package pl.akademiakodu.setup.models;

import lombok.*;

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
}
