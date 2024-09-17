package ci.digitalacademy.monetab.services.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class AbsenceDTO {

    private Long id;

    private Date absence_date;

    private Integer absence_number;

    private StudentDTO studentDTO;
    private String  slug;


}
