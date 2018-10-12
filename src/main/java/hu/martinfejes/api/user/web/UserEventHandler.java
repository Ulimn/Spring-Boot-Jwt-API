package hu.martinfejes.api.user.web;

import hu.martinfejes.api.user.User;
import hu.martinfejes.api.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeLinkDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeLinkSave;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

/**
 * Event handler for the {@link User} entity.
 */
@Component
@RepositoryEventHandler
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class UserEventHandler {

  private final UserService userService;

  /**
   * Encrypt the password on create/update.
   * @param user
   */
  @HandleBeforeCreate
  @HandleBeforeSave
  public void encryptPassword(User user) {
    user = userService.encryptPassword(user);
  }

  @HandleBeforeCreate
  @HandleBeforeSave
  @HandleBeforeDelete
  @HandleBeforeLinkSave
  @HandleBeforeLinkDelete
  // @PreAuthorize("hasRole('ADMIN')")
  public void onBeforeModify(final User entity){
    // noop
  }
}