package ci.digitalacademy.monetab.controller;

import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.services.TeacherService;
import ci.digitalacademy.monetab.services.dto.TeacherDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/Teachers")
@RequiredArgsConstructor
@Slf4j
public class TeacherControlleur {

    private final TeacherService teacherService;

    @GetMapping
    public String showTeacher(Model model){

        List<TeacherDTO> teachers = teacherService.findAll();
        model.addAttribute("teachers",teachers);

        return "Teacher/list";
    }

    @GetMapping("/show_add_Teacher_form")
    public String showAjouterEleve(Model model){

        log.debug("Request to show add teacher forms");
        model.addAttribute("teachers", new Teacher());
        return "/Teacher/form";
    }

    @PostMapping
    public String saveTeacher(TeacherDTO teacherDTO){

        log.debug("Request to save teacher : {}",teacherDTO );
        teacherService.save(teacherDTO);

        return "redirect:/Teachers";
    }

    @GetMapping("/updateTeacher/{id}")
    public String showModifierEleve(Model model, @PathVariable Long id){

        log.debug("Request to show update teacher forms");
        Optional<TeacherDTO> teacher = teacherService.findOne(id);
        if (teacher.isPresent()){
            model.addAttribute("teachers" , teacher.get());
            return "Teacher/form";
        } else {
            return "redirect:/Teachers";
        }

    }

    @PostMapping("/deleteTeacher/{id}")
    public String showDeleteTeacher(@PathVariable Long id) {
        log.debug("Request to delete teacher with id: {}", id);
        teacherService.delecte(id);
        return "redirect:/Teachers";
    }

}
