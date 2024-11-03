package tetrada.org.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tetrada.org.dto.JwtInfoDto;
import tetrada.org.dto.SessionCreateDto;
import tetrada.org.entity.Session;
import tetrada.org.mapper.SessionCreateMapper;
import tetrada.org.repository.SessionRepository;
import tetrada.org.service.JwtService;
import tetrada.org.service.SessionService;

@RequiredArgsConstructor
@Service
public class SessionServiceImpl implements SessionService {

    private final SessionCreateMapper sessionCreateMapper;
    private final SessionRepository sessionRepository;
    private final JwtService jwtService;

    @Override
    public String create(SessionCreateDto userInfo) {
        Session session = sessionRepository.save(sessionCreateMapper.map(userInfo));
        //ToDo... add locate user
        return jwtService.generateToken(new JwtInfoDto(session.getUid(), userInfo.getUserId()));
    }
}
