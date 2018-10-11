/**
 * 
 */
package hu.martinfejes.api.user.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception to handle invalid {@link hu.martinfejes.api.user.Email} addresses.
 */
@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class InvalidEmailException extends RuntimeException {

	private static final long serialVersionUID = 4935183262936709675L;
}
