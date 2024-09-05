package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.repositories.FicheRepository;
import ci.digitalacademy.monetab.services.FicheService;
import ci.digitalacademy.monetab.services.dto.FicheNoteDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FicheNoteServiceImpl implements FicheService
{
    private final FicheRepository ficheRepository;

    @Override
    public FicheNoteDTO save(FicheNoteDTO ficheNoteDTO) {
        return null;
    }

    @Override
    public FicheNoteDTO update(FicheNoteDTO ficheNoteDTO) {
        return null;
    }

    @Override
    public Optional<FicheNoteDTO> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public List<FicheNoteDTO> findAll() {
        return List.of();
    }

    @Override
    public void delecte(Long id) {

    }
}
