package tetrada.org.mapper;

import org.springframework.stereotype.Component;
import tetrada.org.dto.UserCreateDto;
import tetrada.org.entity.User;

@Component
public class UserCreateMapper implements Mapper<UserCreateDto, User>{
    @Override
    public User map(UserCreateDto object) {
        return User.builder()
                .login(object.getLogin())
                .password(object.getPassword())
                .firstName(object.getFirstName())
                .lastName(object.getLastName())
                .build();
    }
}