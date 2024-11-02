package tetrada.org.mapper;

import org.springframework.stereotype.Component;
import tetrada.org.dto.UserUpdateDto;
import tetrada.org.entity.User;

@Component
public class UserUpdateMapper implements Mapper<UserUpdateDto, User> {
    @Override
    public User map(UserUpdateDto fromObject, User toObject) {
        Object temp;
        if((temp = fromObject.getLogin()) != null){
            toObject.setLogin((String)temp);
        }
        if((temp = fromObject.getPassword()) != null){
            toObject.setPassword((String)temp);
        }
        if((temp = fromObject.getFirstName()) != null){
            toObject.setFirstName((String)temp);
        }
        if((temp = fromObject.getLastName()) != null){
            toObject.setLastName((String)temp);
        }
        if((temp = fromObject.getAvatar()) != null){
            toObject.setAvatar((String)temp);
        }
        return toObject;
    }
}
