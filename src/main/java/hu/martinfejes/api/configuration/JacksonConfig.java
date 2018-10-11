package hu.martinfejes.api.configuration;

import com.fasterxml.jackson.databind.Module;
import hu.martinfejes.api.user.web.UserModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class for configuring the Jackson.
 */
@Configuration
public class JacksonConfig {

    public @Bean
    Module userModule() {
        return new UserModule();
    }

}
