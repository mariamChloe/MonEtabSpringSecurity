package ci.digitalacademy.monetab.WebRessource;

import ci.digitalacademy.monetab.services.TeacherService;
import ci.digitalacademy.monetab.services.dto.TeacherDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/Teachers")
public class TeacherRessource {
    private final TeacherService teacherService;


    @PostMapping
//on utilise @RequestBody car cest la methode post et postman s'attend a un corp lorsque cest un postmapping
    public ResponseEntity<TeacherDTO> saveTeacher(@RequestBody TeacherDTO teacherDTO) {
        log.debug("Request to save Teacher : {}, teacherDTO");
        return new ResponseEntity<>(teacherService.save(teacherDTO), HttpStatus.CREATED);


    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherDTO>updateTeacher(TeacherDTO teacherDTO ,Long id) {
        teacherDTO.setId(id);

        return TeacherService.updateTeacher(teacherDTO,id);


    }

}


