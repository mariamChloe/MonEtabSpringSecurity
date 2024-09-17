package ci.digitalacademy.monetab.services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonnDTO {


    private Long id;

    private String nom;

    private String prenom;

    private String telephone;

    private String ville;

    private String email;

    private String genre;

    private StudentDTO studentDTO;

    private TeacherDTO teacherDTO;
private AddressDTO addressDTO;
private UserDTO userDTO;





}
