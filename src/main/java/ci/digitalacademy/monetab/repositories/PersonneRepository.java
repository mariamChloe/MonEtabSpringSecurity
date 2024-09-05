package ci.digitalacademy.monetab.repositories;

import ci.digitalacademy.monetab.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Person, Long> {
}
