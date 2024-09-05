package ci.digitalacademy.monetab.services;

import ci.digitalacademy.monetab.models.FicheNote;
import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.services.dto.FicheNoteDTO;

import java.util.List;
import java.util.Optional;

public interface FicheService {

    FicheNoteDTO save(FicheNoteDTO ficheNoteDTO);

    FicheNoteDTO update(FicheNoteDTO ficheNoteDTO);

    Optional<FicheNoteDTO> findOne(Long id);

    List<FicheNoteDTO> findAll();

    void delecte(Long id);
}
