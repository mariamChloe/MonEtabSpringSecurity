package ci.digitalacademy.monetab.WebRessource;

import ci.digitalacademy.monetab.services.StudentService;
import ci.digitalacademy.monetab.services.dto.RegistrationStudentDTO;
import ci.digitalacademy.monetab.services.dto.StudentDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentRessource {

    private final StudentService studentService;

    /*@PostMapping
    @ApiResponse(responseCode = "201", description = "Student created successfully")
    @Operation(summary = "Save new student", description = "This endpoint allows saving a new student")
    public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO studentDTO) {
        log.debug("REST Request to save student: {}", studentDTO);
        StudentDTO savedStudent = studentService.save(studentDTO);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

     */



    @PutMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Request to get student")
    @Operation (summary = "find one student", description = "this endpoint allows to finc")
    public StudentDTO updateStudent( @RequestBody StudentDTO studentDTO, @PathVariable Long id){

                log.debug(" REST Request to update  {}", studentDTO);
        return studentService.update(studentDTO, id);
    }

    @GetMapping("/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request to get student"),
            @ApiResponse(responseCode = "404", description = "student not found", content = @Content(schema = @Schema(implementation = String.class)))
    })
    public ResponseEntity<?> getStudent(@PathVariable Long id){
       // @Parameter(required = true, description = "ID of student to be retrieved")


                log.debug(" REST Request to get one  ");
        Optional<StudentDTO> studentDTO = studentService.findOne(id);
        if (studentDTO.isPresent()) {
            return new ResponseEntity<>(studentDTO.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<StudentDTO> getAllStudent(){
        log.debug("REST Request to all student ");
        return studentService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        log.debug("REST Request to delete  ");
    }
    @PostMapping("/register-student")
    @ResponseStatus(HttpStatus.CREATED)
    public RegistrationStudentDTO registerStudent(@RequestBody RegistrationStudentDTO registrationStudentDTO) {
        log.debug("REST Request to register student : {}", registrationStudentDTO);
        return studentService.registerStudent(registrationStudentDTO);
    }
}
