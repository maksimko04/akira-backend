package tetrada.org.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tetrada.org.client.SessionClient;
import tetrada.org.dto.UserCreateDto;
import tetrada.org.dto.UserReadDto;
import tetrada.org.dto.UserUpdateDto;
import tetrada.org.service.UserService;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;
    private final SessionClient sessionClient;

    @Transactional
    @PostMapping("create")
    public ResponseEntity<Object> createUser(HttpServletRequest req, @RequestBody @Validated UserCreateDto userRequest){
        UserReadDto user = userService.create(userRequest);
        HashMap<String, Object> response = new HashMap<>();
        response.put("user", user);
        response.put("session", sessionClient.createSession(user.getId(), req.getRemoteAddr(), req.getHeader("User-Agent")).block());
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("read/{id:\\d+}")
    public ResponseEntity<Object> readUser(@PathVariable("id") Long id){
        HashMap<String, Object> response = new HashMap<>();
        response.put("user", userService.readCachedById(id));
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("edit/{id:\\d+}")
    public ResponseEntity<Object> editUser(@RequestBody @Validated UserUpdateDto user, @PathVariable Long id){
        HashMap<String, Object> response = new HashMap<>();
        response.put("user", userService.update(user, id));
        return ResponseEntity.ok().body(response);
    }
}