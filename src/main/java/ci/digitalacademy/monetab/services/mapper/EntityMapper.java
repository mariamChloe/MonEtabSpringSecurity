package ci.digitalacademy.monetab.services.mapper;

import ci.digitalacademy.monetab.models.Absence;
import ci.digitalacademy.monetab.models.AppSetting;
import ci.digitalacademy.monetab.models.School;
import ci.digitalacademy.monetab.services.dto.AbsenceDTO;
import ci.digitalacademy.monetab.services.dto.AppSettingDTO;
import ci.digitalacademy.monetab.services.dto.SchoolDTO;

public interface EntityMapper<D, E> {

    D toDto(E entity);

    E toEntity(D dto);

    SchoolDTO fromEntity(School school);

    AbsenceDTO fromEntity(Absence absence);

    AppSettingDTO fromEntity(AppSetting appSetting);

}
