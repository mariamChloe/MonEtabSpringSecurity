package ci.digitalacademy.monetab.services;

import ci.digitalacademy.monetab.services.dto.RoleUserDTO;

import java.util.List;
import java.util.Optional;

public interface RoleUserService {

    RoleUserDTO save(RoleUserDTO roleUserDTO);

    RoleUserDTO update(RoleUserDTO roleUserDTO);

    Optional<RoleUserDTO> findOne(Long id);

    List<RoleUserDTO> initRoles(List<RoleUserDTO> roleUsers);

    List<RoleUserDTO> findAll();

    void initRole(List<RoleUserDTO> roles);

    void delete(Long id);
}
