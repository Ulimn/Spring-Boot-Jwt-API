package hu.martinfejes.api.user;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import hu.martinfejes.api.user.web.UserProjection;

/**
 * Repository class for {@link User}, using excerpt {@link UserProjection}.
 */
@RepositoryRestResource(excerptProjection = UserProjection.class)
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByEmail(Email email);
}
