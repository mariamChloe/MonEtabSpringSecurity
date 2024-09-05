package ci.digitalacademy.monetab.services.mapper;

import ci.digitalacademy.monetab.models.Note;
import ci.digitalacademy.monetab.services.dto.NoteDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoteMapper  extends EntityMapper<NoteDTO, Note>{
}
