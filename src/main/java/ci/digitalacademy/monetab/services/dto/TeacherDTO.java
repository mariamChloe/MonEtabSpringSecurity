package ci.digitalacademy.monetab.services.dto;

import ci.digitalacademy.monetab.models.FicheNote;
import ci.digitalacademy.monetab.models.Person;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class TeacherDTO extends PersonnDTO {

    private String matiere;

    private Boolean vacant;

    private PersonnDTO personnDTO;

    private Set<FicheNoteDTO> ficheNoteDTOS;
}
