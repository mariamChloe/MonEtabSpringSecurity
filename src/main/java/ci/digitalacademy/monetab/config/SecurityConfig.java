package ci.digitalacademy.monetab.config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                //.csrf(CsrfConfigurer::disable)  // Désactiver la protection CSRF pour cette configuration
                .authorizeHttpRequests((authorize) -> authorize
                        .dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()  // Autoriser les types de requêtes FORWARD et ERROR

                        .requestMatchers("/css/**").permitAll()  // Permettre l'accès aux ressources css
                        .requestMatchers("/icon/**").permitAll()  // Permettre l'accès aux ressources icon
                        .requestMatchers("/js/**").permitAll()  // Permettre l'accès aux ressources js
                        .requestMatchers("/appSetting/**").permitAll()  // Autoriser l'accès au point de terminaison /app-setting
                        .requestMatchers("/appSetting/school").permitAll()  // Autoriser l'accès au point de terminaison /school-setting
                                .requestMatchers("/appSetting/update").permitAll()  // Autoriser l'accès au point de terminaison /school-setting
                                .requestMatchers("/Users/**").permitAll()  // Autoriser l'accès au point de terminaison /school-setting
                                .requestMatchers("/Users/**").authenticated() // Autoriser les requêtes vers /Users/**

                                .requestMatchers("/api/students/**").permitAll()  // Autoriser l'accès au point de terminaison /student
                        .requestMatchers("/api/Teachers/**").permitAll()  // Autoriser l'accès au point de terminaison /student
                        .requestMatchers("/swagger-ui-**").permitAll()
                                .requestMatchers("/v3/api-docs-**").permitAll()  // Autoriser l'accès au point de terminaison /student
// Autoriser l'accès au point de terminaison /student



                        .requestMatchers("/images/**").permitAll()  // Permettre l'accès aux ressources images
                        .requestMatchers("/public/**").permitAll()  // Permettre l'accès aux ressources publiques (non authentifiées)
                        .anyRequest().authenticated()  // Toutes les autres demandes nécessitent une authentification
                )
                .formLogin((login) -> login
                        .loginPage("/Auth").permitAll()  // Autoriser l'accès à la page de connexion pour tout le monde
                        .defaultSuccessUrl("/Home", true)  // Rediriger vers /home après une connexion réussie
                        .failureUrl("/login?error=true")  // Rediriger vers la page de connexion avec une erreur en cas d'échec
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout")  // URL de déconnexion
                        .logoutSuccessUrl("/Auth")  // Rediriger vers la page de connexion après déconnexion
                        .invalidateHttpSession(true)  // Invalider la session après déconnexion
                        .deleteCookies("JSESSIONID")  // Supprimer le cookie de session après déconnexion
                        .permitAll()  // Permettre à chacun de se déconnecter
                );

        return http.build();
    }
    @Bean
    public BCryptPasswordEncoder PasswordEndcoder(){
        return new BCryptPasswordEncoder();
    }
}

