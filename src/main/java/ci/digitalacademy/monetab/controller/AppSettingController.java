package ci.digitalacademy.monetab.controller;

import ci.digitalacademy.monetab.services.AppSettingService;
import ci.digitalacademy.monetab.services.dto.AppSettingDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/appSetting")
@RequiredArgsConstructor
public class AppSettingController {

    private final AppSettingService appSettingService;

    @GetMapping
    public String showApp(Model model) {
        AppSettingDTO appSettingDTO = new AppSettingDTO();
        appSettingDTO.setSmtpServer("mail");
        appSettingDTO.setSmtpUserName("monEcole");
        appSettingDTO.setSmtpPassword("monEcole123");
        appSettingDTO.setSmtpPort(587);

        // Pass the DTO to the view
        model.addAttribute("appSettingDTO", appSettingDTO);
        return "appSetting/app"; // Ensure this matches the Thymeleaf template location
    }

    @GetMapping("/update")
    public String showUpdateForm(Model model) {
        // Récupérer les paramètres actuels de l'utilisateur
        AppSettingDTO appSettingDTO = appSettingService.getCurrentSettings();
        model.addAttribute("appSettingDTO", appSettingDTO);
        return "appSetting/updateAppsetting"; // Nom du template Thymeleaf pour le formulaire de mise à jour
    }

    @PutMapping("/save")
    public String update(@ModelAttribute("appSettingDTO") AppSettingDTO appSettingDTO) {
        appSettingService.update(appSettingDTO);
        return "redirect:/appSetting/updateAppsetting"; // Rediriger vers le formulaire de modification après l'enregistrement
    }

    @PostMapping("/save")
    public String saveAppSetting(AppSettingDTO appSettingDTO) {
        // Save the AppSettingDTO using the service
        appSettingService.save(appSettingDTO);
        // Redirect to the desired page after saving
        return "redirect:/school";
    }
}