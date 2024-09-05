package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.repositories.AdresseRepository;
import ci.digitalacademy.monetab.services.AdresseService;
import ci.digitalacademy.monetab.services.dto.AddressDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service

public class AdresseServiceImpl implements AdresseService {

    private final AdresseRepository adresseRepository;


    @Override
    public AddressDTO save(AddressDTO addressDTO) {
        return null;
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO) {
        return null;
    }

    @Override
    public Optional<AddressDTO> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public List<AddressDTO> findAll() {
        return List.of();
    }

    @Override
    public void delecte(Long id) {

    }
}
