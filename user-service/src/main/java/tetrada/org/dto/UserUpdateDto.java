package tetrada.org.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tetrada.org.validator.WithoutSpace;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDto {
    @Size(min = 5, max = 20)
    @WithoutSpace
    private String login;
    @WithoutSpace
    private String password;
    @WithoutSpace
    private String firstName;
    @WithoutSpace
    private String lastName;
    private String avatar;
    private String oldPassword;
}