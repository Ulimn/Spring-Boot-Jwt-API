/**
 * 
 */
package hu.martinfejes.api.user.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception to handle missing {@link hu.martinfejes.api.user.User}.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2462491578845933421L;
}
