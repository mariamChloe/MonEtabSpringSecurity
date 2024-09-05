package ci.digitalacademy.monetab.repositories;

import ci.digitalacademy.monetab.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByPseudo(String pseudo);

    // Updated method name to correctly reference the 'role' field inside the 'RoleUser' entity
    List<User> findByCreationdateLessThanAndRoleUsers_Role(Instant creationDate, String role);
}
