package mx.com.bluesky;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurationSupport {
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/static/js/**",
                "/static/css/**")
                .addResourceLocations(
                        "classpath:/static/js/",
                        "classpath:/static/css/");
    }
    
}
