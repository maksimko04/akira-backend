package tetrada.org.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SessionCreateDto {
    private Long userId;
    private String ip;
    private String device;
}
