package hu.martinfejes.api.configuration;

import com.github.slugify.Slugify;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

@Component
@EnableJpaAuditing
public class AppConfig {

    @Bean
    Slugify slugify() {
        return new Slugify();
    }

}
