package ci.digitalacademy.monetab.services;

import ci.digitalacademy.monetab.services.dto.AppSettingDTO;

import java.util.List;
import java.util.Optional;

public interface AppSettingService {

    AppSettingDTO save(AppSettingDTO appSettingDTO);

    AppSettingDTO update(AppSettingDTO appSettingDTO);

    Optional<AppSettingDTO> findOne(Long id);

    List<AppSettingDTO> findAll();

    void delecte(Long id);

    List<AppSettingDTO> findAllBySmtpUserName(String smtpuserneme );
}
