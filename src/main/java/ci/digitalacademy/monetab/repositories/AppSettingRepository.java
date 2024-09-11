package ci.digitalacademy.monetab.repositories;

import aj.org.objectweb.asm.commons.Remapper;
import ci.digitalacademy.monetab.models.AppSetting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface AppSettingRepository extends JpaRepository<AppSetting, Long> {
    Collection<Object> findBySmtpUserName(String smtpUserName);
    Optional<AppSetting> findById(Long Id);


    Remapper findTopByOrderByIdDesc();
}
