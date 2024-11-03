package tetrada.org.mapper;

import org.springframework.stereotype.Component;
import tetrada.org.dto.UserCreateDto;
import tetrada.org.entity.User;

@Component
public class UserCreateMapper implements Mapper<UserCreateDto, User>{
    @Override
    public User map(UserCreateDto userCreateDto) {
        User user = new User();
        user.setLogin(userCreateDto.getLogin());
        user.setFirstName(userCreateDto.getFirstName());
        user.setLastName(userCreateDto.getLastName());
        user.setPassword(userCreateDto.getPassword());
        return user;
    }
}