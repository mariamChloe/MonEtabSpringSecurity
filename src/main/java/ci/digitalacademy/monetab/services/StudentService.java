package ci.digitalacademy.monetab.services;


import ci.digitalacademy.monetab.services.dto.RegistrationStudentDTO;
import ci.digitalacademy.monetab.services.dto.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    StudentDTO save(StudentDTO studentDTO);

    StudentDTO update(StudentDTO studentDTO, Long id);

    Optional<StudentDTO> findOne(Long id);

    List<StudentDTO> findAll();

    void delecte(Long id);

    List<StudentDTO> findByNomOrGenreOrMatricule(String query, String genre);

    boolean existsById(Long id);

    void delete(Long id);

    RegistrationStudentDTO registerStudent(RegistrationStudentDTO registrationStudentDTO);

}
