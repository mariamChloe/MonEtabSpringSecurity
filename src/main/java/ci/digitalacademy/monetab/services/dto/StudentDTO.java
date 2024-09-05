package ci.digitalacademy.monetab.services.dto;

import ci.digitalacademy.monetab.models.Absence;
import ci.digitalacademy.monetab.models.Person;
import ci.digitalacademy.monetab.models.StudentCards;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class StudentDTO extends PersonnDTO {

    private String matricule;

    private String classe;

    private LocalDate datenaiss;

    private Integer age;

    private Set<AbsenceDTO> absenceDTOS;

    private StudentCardsDTO studentCardsDTO;

    private PersonnDTO personnDTO;
}
