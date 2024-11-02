package tetrada.org.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tetrada.org.validator.WithoutSpace;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto {
    @Size(min = 5, max = 20)
    @WithoutSpace
    private String login;
    @Size(min = 6, max = 25)
    @WithoutSpace
    private String password;
    @WithoutSpace
    private String firstName;
    @WithoutSpace
    private String lastName;
}