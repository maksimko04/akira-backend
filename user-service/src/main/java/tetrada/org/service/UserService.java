package tetrada.org.service;

import tetrada.org.dto.UserCreateDto;
import tetrada.org.dto.UserReadDto;
import tetrada.org.dto.UserUpdateDto;
import tetrada.org.entity.User;
import tetrada.org.exception.UserExistsException;

import java.util.List;

public interface UserService {
    UserReadDto create(UserCreateDto user) throws UserExistsException;
    UserReadDto readById(Long id);
    UserReadDto readCachedById(Long id);
    UserReadDto update(UserUpdateDto user, Long id);
    void delete(long id);
}