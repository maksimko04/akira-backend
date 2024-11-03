package tetrada.org.service.impl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import tetrada.org.dto.JwtInfoDto;
import tetrada.org.service.JwtService;

@Service
public class JwtServiceImpl implements JwtService {
    private final String SECRET = "qZoRZL2wIMZvXvpN2MLxEZm8pXjqZ8du7zVRLjdi4eaGfc5l5Tv45Wolo6vNnuubqZoRZL2wIMZvXvpN2MLxEZm8pXjqZ8du7zVRLjdi4eaGfc5l5Tv45Wolo6vNnuub";

    public String generateToken(JwtInfoDto session) {
        return Jwts.builder()
                .setSubject(session.toString())
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }
}
