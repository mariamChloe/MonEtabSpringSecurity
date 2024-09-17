package ci.digitalacademy.monetab.services;

import ci.digitalacademy.monetab.services.dto.UserDTO;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDTO save(UserDTO userDTO);

    UserDTO update(UserDTO userDTO);

    UserDTO update(Long id, UserDTO userDTO);

    Optional<UserDTO> findOne(Long id);

    List<UserDTO> findAll();

    void delecte(Long id);

    List<UserDTO> initUser(List<UserDTO> users);

    List<UserDTO> findByCreationdateLessThanAndRoleUsers(Instant creationdate, String role);

    Optional<UserDTO> findBySpeudo(String speudo);
    void updateUserStatus(Long id, String status);

    UserDTO findBySlug(String slug);
    UserDTO partialUpdate(Long id, UserDTO userDTO);

    void delete(Long id);
    UserDTO findById(Long id);




}
