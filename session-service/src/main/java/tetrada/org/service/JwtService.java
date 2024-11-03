package tetrada.org.service;

import tetrada.org.dto.JwtInfoDto;

public interface JwtService {
    String generateToken(JwtInfoDto session);
}
