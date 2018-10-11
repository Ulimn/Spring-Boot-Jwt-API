package hu.martinfejes.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Implementation for the {@link UserService} interface.
 */
@Service
public class UserServiceImpl implements UserService {

  private final BCryptPasswordEncoder passwordEncorder;

  @Autowired
  public UserServiceImpl(BCryptPasswordEncoder passwordEncorder) {
    this.passwordEncorder = passwordEncorder;
  }

  @Override
  public User encryptPassword(User user) {
    user.setPassword(new Password(passwordEncorder.encode(user.getPassword().getPassword())));
    return user;
  }
}