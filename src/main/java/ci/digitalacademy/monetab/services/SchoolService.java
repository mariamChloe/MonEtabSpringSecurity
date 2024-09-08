package ci.digitalacademy.monetab.services;

import ci.digitalacademy.monetab.models.School;
import ci.digitalacademy.monetab.services.dto.SchoolDTO;

import java.util.List;
import java.util.Optional;

public interface SchoolService {

    SchoolDTO save(SchoolDTO schoolDTO);

    SchoolDTO update(SchoolDTO schoolDTO);

    Optional<SchoolDTO> findOne(Long id);

    List<SchoolDTO> findAll();
    boolean isConfigured();






    SchoolDTO initSchool(SchoolDTO schoolDTO);

    Optional<School> existingSchool();

    void delete(Long id);

    School getSchool();
}
