package tetrada.org.mapper;

import org.springframework.stereotype.Component;
import tetrada.org.dto.UserReadDto;
import tetrada.org.entity.User;

@Component
public class UserReadMapper implements Mapper<User, UserReadDto>{
    @Override
    public UserReadDto map(User object) {
        return new UserReadDto(object.getId(), object.getLogin(), object.getFirstName(),
                object.getLastName(), object.getAvatar(), object.getRole(), object.isVerified());
    }
}