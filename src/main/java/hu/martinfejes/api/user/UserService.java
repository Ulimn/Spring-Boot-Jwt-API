package hu.martinfejes.api.user;

import org.springframework.stereotype.Service;

/**
 * Service for the {@link User} entity.
 */
@Service
public interface UserService {

  public User encryptPassword(User user);
}