package tetrada.org.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import tetrada.org.dto.SessionCreateDto;

@Component
public class SessionClient {
    @Autowired
    private WebClient webClient;

    public Mono<String> createSession(Long userId, String ip, String device){
        return webClient.post()
                .uri("http://session-service/service/create")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new SessionCreateDto(userId, ip, device))
                .header("secretKey", "cbsoud;gbsu749fb2b4r[gh0h3 gaw94tvbg[h34q8rgf")
                .retrieve()
                .bodyToMono(String.class);
    }
}