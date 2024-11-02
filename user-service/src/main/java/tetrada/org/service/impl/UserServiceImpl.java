package tetrada.org.service.impl;

import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tetrada.org.dto.UserCreateDto;
import tetrada.org.dto.UserReadDto;
import tetrada.org.dto.UserUpdateDto;
import tetrada.org.entity.User;
import tetrada.org.exception.IncorrectPasswordException;
import tetrada.org.exception.UserExistsException;
import tetrada.org.exception.UserNotFoundException;
import tetrada.org.mapper.UserCreateMapper;
import tetrada.org.mapper.UserReadMapper;
import tetrada.org.mapper.UserUpdateMapper;
import tetrada.org.repository.UserRepository;
import tetrada.org.service.UserService;

import java.util.concurrent.TimeUnit;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    private UserCreateMapper userCreateMapper;
    private UserReadMapper userReadMapper;
    private UserUpdateMapper userUpdateMapper;
    private PasswordEncoder passwordEncoder;
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public UserReadDto create(UserCreateDto userDto) {
        User user = userCreateMapper.map(userDto);
        if(userRepository.findByLogin(user.getLogin()).isPresent()){
            throw new UserExistsException();
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userReadMapper.map(userRepository.save(user));
    }

    @Override
    public UserReadDto readById(Long id) {
        return userReadMapper.map(userRepository.findById(id).orElseThrow(UserNotFoundException::new));
    }

    @Override
    public UserReadDto readCachedById(Long id) {
        String key = "user:%d".formatted(id);
        UserReadDto user = (UserReadDto) redisTemplate.opsForValue().get(key);
        if(user != null){
            redisTemplate.expire(key, 10, TimeUnit.MINUTES);
            return user;
        }
        user = readById(id);
        redisTemplate.opsForValue().set(key, user);
        redisTemplate.expire(key, 10, TimeUnit.MINUTES);
        return user;
    }

    @Override
    public UserReadDto update(UserUpdateDto userUpdateDto, Long id) {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        if(userUpdateDto.getPassword() == null){
            userUpdateDto.setPassword(null);
            return userReadMapper.map(userRepository.save(userUpdateMapper.map(userUpdateDto, user)));
        }
        if(userUpdateDto.getOldPassword() != null && passwordEncoder.matches(userUpdateDto.getOldPassword(), user.getPassword())){
            String newPassword = userUpdateDto.getPassword();
            if(newPassword.length() < 6 || newPassword.length() > 25){
                throw new ValidationException();
            }
            userUpdateDto.setPassword(passwordEncoder.encode(newPassword));
            return userReadMapper.map(userRepository.save(userUpdateMapper.map(userUpdateDto, user)));
        }
        throw new IncorrectPasswordException();
    }

    @Override
    public void delete(long id) {

    }
}