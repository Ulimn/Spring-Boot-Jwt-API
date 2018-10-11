package hu.martinfejes.api.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import hu.martinfejes.api.user.Email;
import hu.martinfejes.api.user.User;
import hu.martinfejes.api.user.UserRepository;
import lombok.RequiredArgsConstructor;

/**
 * Custom implementation for {@link UserDetailsService}.
 * It looks up a {@link User} by {@link User#email} string.
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(new Email(s));

        if (user == null) {
            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", s));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });

        return new org.springframework.security.core.userdetails.
                User(user.getEmail().getEmail(), user.getPassword().getPassword(), authorities);
    }


}
