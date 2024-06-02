package org.example.appconfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Spring Boot ustaliłby ścieżkę automatycznie, a że korzystamy z samego Springa, to musimy zrobić to ręcznie
@Configuration
public class AppConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }


}
