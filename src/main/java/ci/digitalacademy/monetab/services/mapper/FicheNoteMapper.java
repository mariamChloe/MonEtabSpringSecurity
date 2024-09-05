package ci.digitalacademy.monetab.services.mapper;

import ci.digitalacademy.monetab.models.FicheNote;
import ci.digitalacademy.monetab.services.dto.FicheNoteDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FicheNoteMapper extends EntityMapper<FicheNoteDTO, FicheNote>{
}
