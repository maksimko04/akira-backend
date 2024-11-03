package tetrada.org.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tetrada.org.entity.Session;

import java.util.UUID;

@Repository
public interface SessionRepository extends CrudRepository<Session, UUID> {

}
