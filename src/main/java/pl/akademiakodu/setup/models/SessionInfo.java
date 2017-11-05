package pl.akademiakodu.setup.models;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by Patryk Dudzik on 03.11.2017.
 */

@Component
@Data
public class SessionInfo {
    private String username;
    private boolean logged = false;
}
