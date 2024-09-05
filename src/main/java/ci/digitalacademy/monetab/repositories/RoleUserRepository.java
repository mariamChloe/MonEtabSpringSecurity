package ci.digitalacademy.monetab.repositories;

import ci.digitalacademy.monetab.models.RoleUser;
import ci.digitalacademy.monetab.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface RoleUserRepository extends JpaRepository<RoleUser, Long> {


}
