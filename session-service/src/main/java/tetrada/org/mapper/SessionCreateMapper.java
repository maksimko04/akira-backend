package tetrada.org.mapper;

import org.springframework.stereotype.Component;
import tetrada.org.dto.SessionCreateDto;
import tetrada.org.entity.Session;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class SessionCreateMapper implements Mapper<SessionCreateDto, Session>{
    @Override
    public Session map(SessionCreateDto sessionCreateDto) {
        return Session.builder()
                .userId(sessionCreateDto.getUserId())
                .ip(sessionCreateDto.getIp())
                .device(sessionCreateDto.getDevice())
                .lastActivity(LocalDateTime.now(ZoneId.of("UTC")))
                .build();
    }
}
