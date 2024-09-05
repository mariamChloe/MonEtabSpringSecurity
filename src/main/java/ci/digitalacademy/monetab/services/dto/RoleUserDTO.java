package ci.digitalacademy.monetab.services.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleUserDTO  extends PersonnDTO{
    private String role;
}
