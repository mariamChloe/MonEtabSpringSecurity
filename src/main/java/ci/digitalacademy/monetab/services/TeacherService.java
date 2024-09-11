package ci.digitalacademy.monetab.services;

import ci.digitalacademy.monetab.services.dto.TeacherDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface TeacherService {


    static ResponseEntity<TeacherDTO> updateTeacher(TeacherDTO teacherDTO, Long id) {
        return null;
    }

    TeacherDTO save(TeacherDTO teacherDTO);

    TeacherDTO update(TeacherDTO teacherDTO);
    TeacherDTO update(TeacherDTO teacherDTO,  Long id);


    Optional<TeacherDTO> findOne(Long id);

    List<TeacherDTO> findAll();

    void delecte(Long id);

    void delete(Long id);
    List<TeacherDTO> findByNomOrMatiereAndGenre(String query , String genre);




}
