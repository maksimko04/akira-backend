package tetrada.org.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tetrada.org.model.Role;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserReadDto implements Serializable {
    private Long id;
    private String login;
    private String firstName;
    private String lastName;
    private String avatar;
    private Role role;
    private boolean isVerified;
}