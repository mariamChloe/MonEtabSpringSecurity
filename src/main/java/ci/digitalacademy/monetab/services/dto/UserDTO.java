package ci.digitalacademy.monetab.services.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class UserDTO {

    private Long id;

    private String pseudo;

    private String password;

    private Instant creationdate;

    private AddressDTO adresseDTO;
    private String status;
    private String slug;

}
