package ci.digitalacademy.monetab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Home")
public class HomeController {

    @GetMapping
    public String showDashboard(Model model){
        model.addAttribute("logoUrl", "/images/logo.png");  // Adjust the path as necessary

        return "/Home/dashboad";
    }
}
