package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.School;
import ci.digitalacademy.monetab.repositories.SchoolRepository;
import ci.digitalacademy.monetab.services.SchoolService;
import ci.digitalacademy.monetab.services.dto.SchoolDTO;
import ci.digitalacademy.monetab.services.mapper.SchoolMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {
    private final SchoolMapper schoolMapper;
    private final SchoolRepository schoolRepository;

    @Override
    public SchoolDTO initSchool(SchoolDTO schoolDTO) {
        log.debug("Request to init school {}", schoolDTO);
        Optional<School> existingSchool = existingSchool();
        if (!existingSchool.isPresent()) {
            return save(schoolDTO);
        }
        return schoolMapper.toDto(existingSchool.get());
    }

    @Override
    public Optional<School> existingSchool() {
        log.debug("Request to check existing school");
        return schoolRepository.findAll().stream().findFirst();
    }

    @Override
    public SchoolDTO save(SchoolDTO schoolDTO) {
        School school = new School();
        school.setName(schoolDTO.getName());
        school.setUrl_logo(schoolDTO.getUrl_logo());
        // Set other properties
        schoolRepository.save(school);
        return schoolDTO;
    }

    @Override
    public SchoolDTO update(SchoolDTO schoolDTO) {
        log.debug("Request to update school {}", schoolDTO);
        School school = schoolMapper.toEntity(schoolDTO);
        School updatedSchool = schoolRepository.save(school);
        return schoolMapper.toDto(updatedSchool);
    }

    @Override
    public Optional<SchoolDTO> findOne(Long id) {
        log.debug("Request to find school with id {}", id);
        return schoolRepository.findById(id)
                .map(schoolMapper::toDto);
    }

    @Override
    public List<SchoolDTO> findAll() {
        log.debug("Request to find all schools");
        return schoolRepository.findAll().stream()
                .map(schoolMapper::toDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete school with id {}", id);
        schoolRepository.deleteById(id);
    }

    @Override
    public School getSchool() {
        return null;
    }
}
