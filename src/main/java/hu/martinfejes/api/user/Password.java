package hu.martinfejes.api.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Embeddable class to represent password fields.
 */
@Embeddable
@Getter
@ToString
@EqualsAndHashCode
public class Password {

    @NotNull
    @Column(nullable = false) private final String password;

    public Password(String password) {
        this.password = password;
    }

    public Password() {
        this(null);
    }
}