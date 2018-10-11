package hu.martinfejes.api.configuration;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

/**
 * Class for configuring the application.
 */
@Component
@EnableJpaAuditing
public class AppConfig {

}
