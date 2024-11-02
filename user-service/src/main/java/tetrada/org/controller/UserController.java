package tetrada.org.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tetrada.org.dto.UserCreateDto;
import tetrada.org.dto.UserUpdateDto;
import tetrada.org.service.UserService;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @PostMapping("create")
    public ResponseEntity<Object> createUser(@RequestBody @Validated UserCreateDto user){
        HashMap<String, Object> response = new HashMap<>();
        response.put("user", userService.create(user));
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("read/{id:\\d+}")
    public ResponseEntity<Object> readUser(@PathVariable("id") Long id){
        HashMap<String, Object> response = new HashMap<>();
        response.put("user", userService.readCachedById(id));
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("edit/{id:\\d+}")
    public ResponseEntity<Object> createUser(@RequestBody @Validated UserUpdateDto user, @PathVariable Long id){
        HashMap<String, Object> response = new HashMap<>();
        response.put("user", userService.update(user, id));
        return ResponseEntity.ok().body(response);
    }
}
