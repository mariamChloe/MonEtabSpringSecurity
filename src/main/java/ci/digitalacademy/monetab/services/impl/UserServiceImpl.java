package ci.digitalacademy.monetab.services.impl;


import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.repositories.UserRepository;
import ci.digitalacademy.monetab.services.UserService;
import ci.digitalacademy.monetab.services.dto.UserDTO;
import ci.digitalacademy.monetab.services.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private  final UserMapper userMapper;

    //private final Logger log = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO update(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userMapper.toEntity(userDTO);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public Optional<UserDTO> findOne(Long id) {
        return userRepository.findById(id).map(user -> {
            return userMapper.toDto(user);
        });
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(user -> {
            return userMapper.toDto(user);
        }).toList();
    }

    @Override
    public void delecte(Long id) {
        log.debug("Request to delete user {}",id);
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDTO> initUser(List<UserDTO> users) {
        return null;
    }

    @Override
    public List<UserDTO> findByCreationdateLessThanAndRoleUsers(Instant creationdate, String role) {
        List<User> users = userRepository.findByCreationdateLessThanAndRoleUsers_Role(creationdate, role);
        return users.stream().map(user -> userMapper.toDto(user)).toList();
    }

    @Override
    public Optional<UserDTO> findBySpeudo(String speudo) {
        return userRepository.findByPseudo(speudo).map(user ->
                userMapper.toDto(user));
    }

    @Override
    public void updateUserStatus(Long id, String status) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setStatus(Boolean.parseBoolean(status));
            userRepository.save(user);
        }

    }

    @Override
    public UserDTO findBySlug(String slug) {
        return userRepository.findBySlug(slug)
                .map(userMapper::toDto)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public UserDTO partialUpdate(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userMapper.toEntity(userDTO);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }



    @Override
    public void delete(Long id) {

    }

    @Override
    public UserDTO findById(Long id) {
        return null;
    }


}
