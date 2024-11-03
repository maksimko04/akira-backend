package tetrada.org.service;

import tetrada.org.dto.SessionCreateDto;

public interface SessionService {
    String create(SessionCreateDto userInfo);

}