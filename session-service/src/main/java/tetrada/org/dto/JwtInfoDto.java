package tetrada.org.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@ToString
@AllArgsConstructor
public class JwtInfoDto {
    private UUID uid;
    private Long userId;
}