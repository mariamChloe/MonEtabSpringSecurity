package ci.digitalacademy.monetab.services.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class StudentCardsDTO {


    private Long id;

    private Date reference;

    private Date issue_date;

    private Date expiration_dater;

    private StudentDTO studentDTO;
}
