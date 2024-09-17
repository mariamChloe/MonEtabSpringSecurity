package ci.digitalacademy.monetab.services.Mapping;

import ci.digitalacademy.monetab.models.Absence;
import ci.digitalacademy.monetab.services.dto.AbsenceDTO;

public final class AbsenceMapping {
    private AbsenceMapping(){

    }
    public static void partialUpdate(Absence absence, AbsenceDTO absenceDTO){
        if (absenceDTO.getAbsence_number()!=null){
            absence.setAbsence_number(absenceDTO.getAbsence_number());
        }
        if (absenceDTO.getAbsence_date()!=null){
            absence.setAbsence_date(absenceDTO.getAbsence_date());
        }
    }
}
