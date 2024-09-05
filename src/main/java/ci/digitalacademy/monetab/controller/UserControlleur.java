package ci.digitalacademy.monetab.controller;

import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.services.UserService;
import ci.digitalacademy.monetab.services.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/Users")
@RequiredArgsConstructor
@Slf4j
public class UserControlleur {

    private final UserService userService;

    @GetMapping
    public String showUserPage(Model model){

        List<UserDTO> users = userService.findAll();
        model.addAttribute("users",users);

        return "/User/list";
    }

    @GetMapping("/show_add_user_form")
    public String showAjouterUser(Model model){

        log.debug("Request to show add user forms");
        model.addAttribute("users", new User());
        return "/Users/form";
    }

    @PostMapping
    public String saveUser(@ModelAttribute UserDTO userDTO, @RequestParam("confirmPassword") String confirmPassword, Model model) {
        log.debug("Request to save users : {}", userDTO);

        // Vérifier la correspondance des mots de passe
        if (!userDTO.getPassword().equals(confirmPassword)) {
            model.addAttribute("passwordMismatch", true);
            return "/Users/form";
        }
        // Définir la date de création
        userDTO.setCreationdate(Instant.now());

        userService.save(userDTO);

        return "redirect:/Users";
    }


    @GetMapping("/updateUser/{id}")
    public String showModifierEleve(Model model, @PathVariable Long id){

        log.debug("Request to show update users forms");
        Optional<UserDTO> user = userService.findOne(id);
        if (user.isPresent()){
            model.addAttribute("users" , user.get());
            return "Users/form";
        } else {
            return "redirect:/Users";
        }

    }

    @PostMapping("/deleteUser/{id}")
    public String showDeleteTeacher(@PathVariable Long id) {
        log.debug("Request to delete user with id: {}", id);
        userService.delecte(id);
        return "redirect:/Users";
    }
}
