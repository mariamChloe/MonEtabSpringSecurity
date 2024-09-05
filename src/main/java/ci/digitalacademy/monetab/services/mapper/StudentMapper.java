package ci.digitalacademy.monetab.services.mapper;

import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.services.dto.StudentDTO;
import ci.digitalacademy.monetab.services.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper extends EntityMapper<StudentDTO, Student>{
}
