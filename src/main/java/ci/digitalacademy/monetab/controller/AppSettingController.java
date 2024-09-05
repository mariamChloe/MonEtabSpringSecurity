package ci.digitalacademy.monetab.controller;

import ci.digitalacademy.monetab.services.AppSettingService;
import ci.digitalacademy.monetab.services.dto.AppSettingDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @PostMapping("/save")
    public String saveAppSetting(AppSettingDTO appSettingDTO) {
        // Save the AppSettingDTO using the service
        appSettingService.save(appSettingDTO);
        // Redirect to the desired page after saving
        return "redirect:/school";
    }
}
