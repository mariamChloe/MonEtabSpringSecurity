package ci.digitalacademy.monetab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Rapport")
public class RapportController {

    @GetMapping
    public String showRapport(){
        return "/Rapport/rapport";
    }
}
