package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.repositories.TeacherRepository;
import ci.digitalacademy.monetab.services.TeacherService;
import ci.digitalacademy.monetab.services.dto.TeacherDTO;
import ci.digitalacademy.monetab.services.mapper.TeacherMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @Override
    public TeacherDTO save(TeacherDTO teacherDTO) {
        log.debug("Request to save Teacher : {}", teacherDTO);
        Teacher teacher = teacherMapper.toEntity(teacherDTO);
        teacher = teacherRepository.save(teacher);
        return teacherMapper.toDto(teacher);
    }

    @Override
    public TeacherDTO update(TeacherDTO teacherDTO) {
        log.debug("Request to update Teacher : {}", teacherDTO);
        Teacher teacher = teacherMapper.toEntity(teacherDTO);
        teacher = teacherRepository.save(teacher);
        return teacherMapper.toDto(teacher);
    }

    @Override
    public TeacherDTO update(TeacherDTO teacherDTO, Long id) {
        return null;
    }

    @Override
    public Optional<TeacherDTO> findOne(Long id) {
        log.debug("Request to get Teacher with ID : {}", id);
        return teacherRepository.findById(id).map(teacherMapper::toDto);
    }

    @Override
    public List<TeacherDTO> findAll() {
        log.debug("Request to get all Teachers");
        return teacherRepository.findAll().stream()
                .map(teacherMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delecte(Long id) {

    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Teacher with ID : {}", id);
        teacherRepository.deleteById(id);
    }



    @Override
    public List<TeacherDTO> findByNomOrMatiereAndGenre(String query, String genre) {
        List<Teacher> teachers = teacherRepository.findByNomOrMatiereAndGenre(query , query , genre);
        return teachers.stream().map(teacher -> teacherMapper.toDto(teacher)).toList();
    }
}
