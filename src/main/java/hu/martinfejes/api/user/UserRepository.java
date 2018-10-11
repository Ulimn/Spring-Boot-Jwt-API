package hu.martinfejes.api.user;

import hu.martinfejes.api.user.web.UserProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Repository class for {@link User}, using excerpt {@link UserProjection}.
 */
@RepositoryRestResource(excerptProjection = UserProjection.class)
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByEmail(Email email);
}
