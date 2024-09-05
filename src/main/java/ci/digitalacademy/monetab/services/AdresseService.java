package ci.digitalacademy.monetab.services;

import ci.digitalacademy.monetab.services.dto.AddressDTO;

import java.util.List;
import java.util.Optional;

public interface AdresseService {

    AddressDTO save(AddressDTO addressDTO);

    AddressDTO update(AddressDTO addressDTO);

    Optional<AddressDTO> findOne(Long id);

    List<AddressDTO> findAll();

    void delecte(Long id);
}
