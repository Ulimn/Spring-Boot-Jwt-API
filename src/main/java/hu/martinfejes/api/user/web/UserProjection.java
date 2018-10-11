package hu.martinfejes.api.user.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import hu.martinfejes.api.user.User;

/**
 * Interface for the Projection of {@link User}.
 */
@Projection(name = "userExcerpt", types = { User.class })
public interface UserProjection {

	String getName();
	
	@Value("#{target.getEmail().getEmail()}")
	String getEmail();

}