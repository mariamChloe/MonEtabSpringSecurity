package ci.digitalacademy.monetab.services.dto;

import ci.digitalacademy.monetab.models.User;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

    private Long id;

    private String country;

    private String city;

    private String street;

    private UserDTO userDTO;

}
