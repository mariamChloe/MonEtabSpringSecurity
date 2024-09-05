package ci.digitalacademy.monetab.controller;

import ci.digitalacademy.monetab.services.SchoolService;
import ci.digitalacademy.monetab.services.dto.SchoolDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("school")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("schoolDTO", new SchoolDTO()); // Initialize a new SchoolDTO object
        return "appSetting/school"; // Return the name of the Thymeleaf template for the form
    }

    @PostMapping("/save")
    public String saveSchool(SchoolDTO schoolDTO) {
        schoolService.save(schoolDTO); // Save the school details
        return "redirect:/Auth"; // Redirect to /auth after successful registration
    }
}
