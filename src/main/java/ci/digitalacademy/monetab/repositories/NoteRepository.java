package ci.digitalacademy.monetab.repositories;

import ci.digitalacademy.monetab.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
