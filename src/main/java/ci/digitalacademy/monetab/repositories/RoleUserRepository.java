package ci.digitalacademy.monetab.repositories;

import ci.digitalacademy.monetab.models.RoleUser;
import ci.digitalacademy.monetab.services.dto.RoleUserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleUserRepository extends JpaRepository<RoleUser, Long> {
    List<RoleUserDTO>findByRole(String role);


}
