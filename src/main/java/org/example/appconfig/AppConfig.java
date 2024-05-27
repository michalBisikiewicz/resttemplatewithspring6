package org.example.appconfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

//Spring Boot ustaliłby ścieżkę automatycznie, a że korzystamy z samego Springa, to musimy zrobić to ręcznie
@Configuration
public class AppConfig {
    @Bean
    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocation(new ClassPathResource("application.properties"));
        return configurer;
    }
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }


}
