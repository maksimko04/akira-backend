package tetrada.org.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "sessions")
public class Session {
    @Id
    private UUID uid;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "last_activity", columnDefinition = "TIMESTAMP")
    private LocalDateTime lastActivity;

    private String ip;
    private String locate;
    private String device;

    @PrePersist
    public void prePersist(){
        if(uid == null){
            uid = UUID.randomUUID();
        }
    }
}
