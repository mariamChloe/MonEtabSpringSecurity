package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.RoleUser;
import ci.digitalacademy.monetab.repositories.RoleUserRepository;
import ci.digitalacademy.monetab.services.RoleUserService;
import ci.digitalacademy.monetab.services.dto.RoleUserDTO;
import ci.digitalacademy.monetab.services.mapper.RoleUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class RoleUserServiceImpl implements RoleUserService {
    private final RoleUserRepository roleUserRepository;
    private final RoleUserMapper roleUserMapper;

    @Override
    public List<RoleUserDTO> initRoles(List<RoleUserDTO> roleUsers) {
        log.debug("Request to init roles: {}", roleUsers);

        List<RoleUserDTO> existingRoles = findAll();
        if (existingRoles.isEmpty()) {
            roleUsers.forEach(roleUserDTO -> save(roleUserDTO));
        }
        return findAll();
    }

    @Override
    public List<RoleUserDTO> findAll() {
        List<RoleUser> roleUsers = roleUserRepository.findAll();
        return Collections.singletonList(roleUserMapper.toDto((RoleUser) roleUsers));
    }

    @Override
    public void initRole(List<RoleUserDTO> roles) {
        roles.forEach(this::save);
    }

    @Override
    public void delete(Long id) {
        roleUserRepository.deleteById(id);
    }

    @Override
    public RoleUserDTO save(RoleUserDTO roleUserDTO) {
        RoleUser roleUser = roleUserMapper.toEntity(roleUserDTO);
        roleUser = roleUserRepository.save(roleUser);
        return roleUserMapper.toDto(roleUser);
    }

    @Override
    public RoleUserDTO update(RoleUserDTO roleUserDTO) {
        // Check if the role exists
        if (roleUserRepository.existsById(roleUserDTO.getId())) {
            RoleUser roleUser = roleUserMapper.toEntity(roleUserDTO);
            roleUser = roleUserRepository.save(roleUser);
            return roleUserMapper.toDto(roleUser);
        }
        return null; // Or throw an exception
    }

    @Override
    public Set<Object> findByNameRole(String userRole) {
        return roleUserRepository.findByRole(userRole).stream().map(roleUser -> {
            return roleUserMapper.toEntity(roleUser);
        }).collect(Collectors.toSet());
    }

    @Override
    public Optional<RoleUserDTO> findOne(Long id) {
        return roleUserRepository.findById(id).map(roleUserMapper::toDto);
    }
    @Override
    public List<RoleUser> findByRole(String roleUser) {
        return roleUserRepository.findByRole(roleUser).stream().map(role -> {
            return roleUserMapper.toEntity(role);
        }).toList();
    }
}
