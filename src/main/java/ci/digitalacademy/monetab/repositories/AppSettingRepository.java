package ci.digitalacademy.monetab.repositories;

import ci.digitalacademy.monetab.models.AppSetting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppSettingRepository extends JpaRepository<AppSetting, Long> {
}
