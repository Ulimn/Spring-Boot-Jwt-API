package hu.martinfejes.api.user;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Class for initializing {@link User} entities.
 */
@Service
@RequiredArgsConstructor
public class UserInitializer {

    private final @NonNull UserRepository userRepository;

    private final @NonNull BCryptPasswordEncoder passwordEncoder;

    @EventListener
    public void init(ApplicationReadyEvent event) {
        if (userRepository.count() != 0) {
            return;
        }

        User admin = new User();
        admin.setEmail(new Email("demo-admin@api.hu"));
        admin.setPassword(new Password(passwordEncoder.encode("api")));
        admin.setName("Demo Admin");

        User user = new User();
        user.setEmail(new Email("demo-user@api.hu"));
        user.setPassword(new Password(passwordEncoder.encode("api")));
        user.setName("Demo User");

        userRepository.saveAll(Arrays.asList(admin, user));
    }
}
