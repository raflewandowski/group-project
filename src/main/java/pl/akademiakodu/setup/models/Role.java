package pl.akademiakodu.setup.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Patryk Dudzik on 23.11.2017.
 */
@Data
@NoArgsConstructor
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    private List<User> users;
}
