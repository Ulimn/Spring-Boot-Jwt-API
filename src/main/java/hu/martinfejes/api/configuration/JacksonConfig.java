package hu.martinfejes.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.Module;

import hu.martinfejes.api.user.web.UserModule;

@Configuration
public class JacksonConfig {

    public @Bean
    Module userModule() {
        return new UserModule();
    }

}
