package ci.digitalacademy.monetab.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        // Remplacez les valeurs par celles de votre compte Cloudinary
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dfwcesn1r",
                "api_key", "365993692661642",
                "api_secret", "FSYEg0GkexFFneZC8InnLC13KgE"
        ));
    }
}
