package ci.digitalacademy.monetab.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Auth")
public class AuthController {

    @GetMapping
    public String index() {
        // Vérifiez si l'utilisateur est authentifié
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !authentication.getName().equals("anonymousUser")) {
            // Redirigez l'utilisateur vers une autre page (par exemple, le tableau de bord)
            return "redirect:/Home"; // Remplacez "/dashboard" par l'URL appropriée
        }
        // Sinon, affichez la page de connexion
        return "Auth/index";
    }

    @GetMapping("/logout")
    public String logout() {
        // Invalider la session et rediriger vers la page de connexion après déconnexion
        SecurityContextHolder.clearContext(); // Effacez le contexte de sécurité actuel (déconnexion effective)
        return "redirect:/Auth"; // Redirigez vers la page de connexion
    }
}
