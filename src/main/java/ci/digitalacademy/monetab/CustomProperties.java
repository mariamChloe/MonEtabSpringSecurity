package ci.digitalacademy.monetab;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "com.atosacademy.monetab")
public class CustomProperties {
    private  String apiUrl;
}
