package ci.digitalacademy.monetab.repositories;

import ci.digitalacademy.monetab.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findByNomOrMatiereAndGenre(String lastName, String matiere, String genre);

}

