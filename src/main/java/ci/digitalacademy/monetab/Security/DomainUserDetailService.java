package ci.digitalacademy.monetab.Security;

import ci.digitalacademy.monetab.models.RoleUser;
import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DomainUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String pseudo)  {

        final Optional<User> user = userRepository.findByPseudo(pseudo);

        if (!user.isPresent()) {
            throw new IllegalArgumentException("User not found");
        }

        final List<GrantedAuthority> grantedAuthorities = user.get()
                .getRoleUsers()
                .stream()
                .map(RoleUser::getRole)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return user.map(userRecover -> org.springframework.security.core.userdetails.User.builder()
                        .username(userRecover.getPseudo())
                        .password(userRecover.getPassword())
                        .authorities(grantedAuthorities)
                        .build())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}
