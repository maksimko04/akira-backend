package tetrada.org.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tetrada.org.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByLogin(String login);
}
