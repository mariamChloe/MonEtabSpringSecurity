package ci.digitalacademy.monetab.repositories;

import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
