package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.repositories.AppSettingRepository;
import ci.digitalacademy.monetab.services.AppSettingService;
import ci.digitalacademy.monetab.services.dto.AppSettingDTO;
import ci.digitalacademy.monetab.services.mapper.AppSettingMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class AppSettingServiceImpl implements AppSettingService {

    private final AppSettingRepository appSettingRepository;
    private  final AppSettingMapper appSettingMapper;


    @Override
    public AppSettingDTO save(AppSettingDTO appSettingDTO) {
        return null;
    }

    @Override
    public AppSettingDTO update(AppSettingDTO appSettingDTO) {
        return null;
    }

    @Override
    public Optional<AppSettingDTO> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public List<AppSettingDTO> findAll() {
        return List.of();
    }

    @Override
    public void delecte(Long id) {

    }

    @Override
    public List<AppSettingDTO> findAllBySmtpUserName(String smtpuserneme) {
        return List.of();
    }
}
