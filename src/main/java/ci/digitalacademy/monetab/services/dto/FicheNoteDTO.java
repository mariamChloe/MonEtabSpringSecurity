package ci.digitalacademy.monetab.services.dto;


import ci.digitalacademy.monetab.models.Teacher;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class FicheNoteDTO {

    private Long id;

    private String note;

    private Instant annee;

    private TeacherDTO teacherDTO;
}
