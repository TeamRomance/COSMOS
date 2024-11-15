package teamromance.cosmos.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import teamromance.cosmos.domain.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
