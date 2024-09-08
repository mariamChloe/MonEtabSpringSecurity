package ci.digitalacademy.monetab.config;

import ci.digitalacademy.monetab.services.AppSettingService;
import ci.digitalacademy.monetab.services.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class ConfigurationInterceptor implements HandlerInterceptor {

    private final AppSettingService appSettingService;
    private final SchoolService schoolService;


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Check if the application settings and school settings are configured
        if (!appSettingService.isConfigured() || !schoolService.isConfigured()) {
            // Redirect to the app setting page if not configured
            response.sendRedirect("/appSetting");
            return false;
        }
        return true;
    }
}