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

@RequiredArgsConstructor
@Slf4j
@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    private final TeacherMapper teacherMapper;


    @Override
    public TeacherDTO save(TeacherDTO teacherDTO) {
        log.debug("Resquest to save : {}",teacherDTO);
        Teacher teacher = teacherMapper.toEntity(teacherDTO);
        teacher= teacherRepository.save(teacher);

        return  teacherMapper.toDto(teacher);
    }

    @Override
    public TeacherDTO update(TeacherDTO teacherDTO) {
        Teacher teacher = teacherMapper.toEntity(teacherDTO);
        teacher = teacherRepository.save(teacher);
        return teacherMapper.toDto(teacher);
    }

    @Override
    public Optional<TeacherDTO> findOne(Long id) {
        return teacherRepository.findById(id).map(teacher -> {
            return teacherMapper.toDto(teacher);
        });
    }

    @Override
    public List<TeacherDTO> findAll() {
        return teacherRepository.findAll().stream().map(teacher -> {
            return teacherMapper.toDto(teacher);
        }).toList();
    }

    @Override
    public void delecte(Long id) {

        teacherRepository.deleteById(id);
    }
}
