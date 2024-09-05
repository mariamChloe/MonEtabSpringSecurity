package ci.digitalacademy.monetab.services;

import ci.digitalacademy.monetab.services.dto.AppSettingDTO;
import ci.digitalacademy.monetab.services.dto.RoleUserDTO;
import ci.digitalacademy.monetab.services.dto.SchoolDTO;
import ci.digitalacademy.monetab.services.dto.UserDTO;

import java.util.List;

public interface AppService {
    AppSettingDTO initApp(AppSettingDTO  appSettingDTO);
    SchoolDTO initSchool(SchoolDTO schoolDTO,AppSettingDTO appSettingDTO);


    RoleUserDTO initRoles(RoleUserDTO roleUserDTO);
    List<RoleUserDTO> initRoles(List<RoleUserDTO> roleUserDTO);

void initUsers(List<UserDTO> usersDTOS, List<RoleUserDTO> roleUserDTOS, SchoolDTO schoolDTO);
}
