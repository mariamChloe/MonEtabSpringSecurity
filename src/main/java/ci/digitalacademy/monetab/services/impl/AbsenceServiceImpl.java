package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.Absence;
import ci.digitalacademy.monetab.repositories.AbsenceRepository;
import ci.digitalacademy.monetab.services.AbsenceService;
import ci.digitalacademy.monetab.services.Mapping.AbsenceMapping;
import ci.digitalacademy.monetab.services.dto.AbsenceDTO;
import ci.digitalacademy.monetab.services.mapper.AbsenceMapper;
import ci.digitalacademy.monetab.utils.SlugifyUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AbsenceServiceImpl implements AbsenceService {

    private final AbsenceRepository absenceRepository;
    private final AbsenceMapper absenceMapper;


    @Override
    public AbsenceDTO save(AbsenceDTO absenceDTO) {
        log.debug("Request to save absence {}", absenceDTO);
        Absence absence = absenceMapper.toEntity(absenceDTO);
        absence= absenceRepository.save(absence);
        return absenceMapper.toDto(absence);
    }


    @Override
    public AbsenceDTO update(AbsenceDTO absenceDTO) {
        return findOne(absenceDTO.getId()).map(existingAbsence -> {
            existingAbsence.setAbsence_date(absenceDTO.getAbsence_date());
            existingAbsence.setAbsence_number(absenceDTO.getAbsence_number());
            return save(existingAbsence);
        }).orElseThrow(()->new IllegalArgumentException());
    }

    @Override
    public AbsenceDTO update(AbsenceDTO absenceDTO, Long id) {
        absenceDTO.setId(id);
        return update(absenceDTO);
    }

    @Override
    public void delecte(Long id) {

    }


    @Override
    public Optional<AbsenceDTO> findOne(Long id) {
        return absenceRepository.findById(id).map(absence -> {
            return absenceMapper.toDto(absence);
        });
    }

    @Override
    public List<AbsenceDTO> findAll() {
        return absenceRepository.findAll().stream().map(absence -> {
            return absenceMapper.toDto(absence);
        }).toList();

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public AbsenceDTO saveAbsence(AbsenceDTO absenceDTO) {
        final String slug = SlugifyUtils.genereted(absenceDTO.getAbsence_number().toString());
        absenceDTO.setSlug(slug);
        return save(absenceDTO);
    }

    @Override
    public AbsenceDTO partialUpdate(AbsenceDTO absenceDTO, Long id) {
        return absenceRepository.findById(id).map(absence -> {
            AbsenceMapping.partialUpdate(absence, absenceDTO);
            return absence;
        }).map(absenceRepository::save).map(absenceMapper::toDto).orElse(null);
    }


}

