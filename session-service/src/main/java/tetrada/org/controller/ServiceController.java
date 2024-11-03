package tetrada.org.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tetrada.org.dto.SessionCreateDto;
import tetrada.org.service.SessionService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("service")
public class ServiceController {

    private final SessionService sessionService;

    @PostMapping("create")
    public String createSession(@RequestBody SessionCreateDto userInfo){
        return sessionService.create(userInfo);
    }
}