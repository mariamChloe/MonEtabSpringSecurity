package ci.digitalacademy.monetab.services.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class StudentDTO extends PersonnDTO {

    private String matricule;

    private String classe;

    private LocalDate birth;

    private Integer age;

    private Set<AbsenceDTO> absenceDTOS;

    private StudentCardsDTO studentCardsDTO;

    private PersonnDTO personnDTO;

    public void setUser(UserDTO user) {
    }

    public void set(AddressDTO address) {
    }
}
