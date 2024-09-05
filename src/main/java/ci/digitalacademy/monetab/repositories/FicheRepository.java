package ci.digitalacademy.monetab.repositories;

import ci.digitalacademy.monetab.models.FicheNote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FicheRepository extends JpaRepository<FicheNote, Long> {
}
