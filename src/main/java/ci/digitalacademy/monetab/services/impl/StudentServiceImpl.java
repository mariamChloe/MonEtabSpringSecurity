package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.Security.AuthorityPersonn;
import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.repositories.StudentRepository;
import ci.digitalacademy.monetab.services.AddresseService;
import ci.digitalacademy.monetab.services.RoleUserService;
import ci.digitalacademy.monetab.services.StudentService;
import ci.digitalacademy.monetab.services.UserService;
import ci.digitalacademy.monetab.services.dto.*;
import ci.digitalacademy.monetab.services.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;


@RequiredArgsConstructor
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private  final StudentMapper studentMapper;
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleUserService roleUserService;
    private final AddresseService addresseService;
    private final ModelMapper modelMapper;



    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        log.debug("Resqurst to save : {}",studentDTO);
        Student student = studentMapper.toEntity(studentDTO);
        student= studentRepository.save(student);

        return  studentMapper.toDto(student);
    }

    @Override
    public StudentDTO update(StudentDTO studentDTO, Long id) {
        Student student = studentMapper.toEntity(studentDTO);
        student = studentRepository.save(student);
        return studentMapper.toDto(student);
    }

    @Override
    public Optional<StudentDTO> findOne(Long id) {
        return studentRepository.findById(id).map(student -> {
            return studentMapper.toDto(student);
        });
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream().map(student -> {
            return studentMapper.toDto(student);
        }).toList();
    }

    @Override
    public void delecte(Long id) {

        studentRepository.deleteById(id);
    }


    @Override
    public List<StudentDTO> findByNomOrGenreOrMatricule(String query, String genre) {
        List<Student> students = studentRepository.findByNomIgnoreCaseOrMatriculeIgnoreCaseAndGenre(query  , query ,genre);
        return students.stream().map(student -> studentMapper.toDto(student)).toList();
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }
@Override
@Transactional
    public RegistrationStudentDTO registerStudent(RegistrationStudentDTO registrationStudentDTO) {
    log.debug("Request to register student {}", registrationStudentDTO);
    AddressDTO address = modelMapper.map(registrationStudentDTO, AddressDTO.class);
    address = addresseService.save(address);

    Set<Object> roleUsers = roleUserService.findByNameRole(AuthorityPersonn.ROLE_USER);
    UserDTO user = modelMapper.map(registrationStudentDTO, UserDTO.class);
    String password = UUID.randomUUID().toString();
    user.setPassword(bCryptPasswordEncoder.encode(password));
    user = userService.save(user);

    StudentDTO student = modelMapper.map(registrationStudentDTO, StudentDTO.class);
    student.setUser(user);
    student.set(address);
    student = save(student);


    return registrationStudentDTO;
}
}
