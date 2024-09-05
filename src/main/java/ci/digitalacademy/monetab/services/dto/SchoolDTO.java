package ci.digitalacademy.monetab.services.dto;

import ci.digitalacademy.monetab.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchoolDTO {

    private Long id;

    private String name;

    private String url_logo;

    private User user;

    private AppSettingDTO appSettingDTO;
}
