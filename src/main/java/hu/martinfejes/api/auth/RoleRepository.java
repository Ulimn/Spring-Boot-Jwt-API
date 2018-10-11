package hu.martinfejes.api.auth;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Repository class for {@link Role}. Not exported for REST.
 */
@RepositoryRestResource(exported = false)
public interface RoleRepository extends CrudRepository<Role, Long> {
}
