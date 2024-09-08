package ci.digitalacademy.monetab.repositories;

import ci.digitalacademy.monetab.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByCreationdateLessThanAndRoleUsers_Role(Instant creationdate, String role);

    Optional<User> findByPseudo(String pseudo);
}
