package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.AppSetting;
import ci.digitalacademy.monetab.repositories.AppSettingRepository;
import ci.digitalacademy.monetab.services.AppSettingService;
import ci.digitalacademy.monetab.services.dto.AppSettingDTO;
import ci.digitalacademy.monetab.services.mapper.AppSettingMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class AppSettingServiceImpl implements AppSettingService {

    private final AppSettingRepository appSettingRepository;
    private final AppSettingMapper appSettingMapper;

    @Override
    public AppSettingDTO save(AppSettingDTO appSettingDTO) {
        log.debug("Request to save AppSetting : {}", appSettingDTO);
        AppSetting appSetting = appSettingMapper.toEntity(appSettingDTO);
        appSetting = appSettingRepository.save(appSetting);
        return appSettingMapper.toDto(appSetting);
    }

    @Override
    public AppSettingDTO update(AppSettingDTO appSettingDTO) {
        log.debug("Request to update AppSetting : {}", appSettingDTO);
        if (appSettingDTO.getId() == null || !appSettingRepository.existsById(appSettingDTO.getId())) {
            throw new IllegalArgumentException("AppSetting ID does not exist");
        }
        AppSetting appSetting = appSettingMapper.toEntity(appSettingDTO);
        appSetting = appSettingRepository.save(appSetting);
        return appSettingMapper.toDto(appSetting);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AppSettingDTO> findOne(Long id) {
        log.debug("Request to get AppSetting : {}", id);
        return appSettingRepository.findById(id)
                .map(appSettingMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AppSettingDTO> findAll() {
        log.debug("Request to get all AppSettings");
        return appSettingRepository.findAll().stream()
                .map(appSettingMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delecte(Long id) {

    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete AppSetting : {}", id);
        appSettingRepository.deleteById(id);
    }

    @Override
    public List<AppSettingDTO> findAllBySmtpUserName(String smtpuserneme) {
        return null;
    }

    @Override
    public String getLogoUrl() {
        return null;
    }


    @Override
    @Transactional(readOnly = true)
    public boolean isConfigured() {
        log.debug("Checking if the app is configured");
        return appSettingRepository.count() > 0;
    }

    @Override
    public void saveSettings(AppSettingDTO appSettingDTO) {
        log.debug("Request to save settings : {}", appSettingDTO);
        AppSetting appSetting = appSettingMapper.toEntity(appSettingDTO);
        appSettingRepository.save(appSetting);
    }

    @Override
    @Transactional(readOnly = true)
    public AppSettingDTO getCurrentSettings() {
        log.debug("Request to get current settings");
        // Récupérer les paramètres actuels de l'utilisateur depuis la base de données
        Optional<AppSetting> appSetting = appSettingRepository.findById(1L); // Exemple avec un ID statique
        return appSetting.map(appSettingMapper::toDto).orElse(null);
    }
}