package hu.martinfejes.api.user;

import hu.martinfejes.api.user.web.InvalidEmailException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * Embeddable class to represent email fields.
 *
 * @author Martin Fejes
 */
@Embeddable
@Getter
@ToString
@EqualsAndHashCode
public class Email {
	
	@NotNull @Column(nullable = false) private final String email;
	
	public Email(String email) {
		if (!EmailValidator.validate(email)) {
        	throw new InvalidEmailException();
        }
        
        this.email = email;
	}
	
	public Email() {
		this.email = null;
	}
}