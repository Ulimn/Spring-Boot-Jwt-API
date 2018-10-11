/**
 *
 */
package hu.martinfejes.api.user;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import hu.martinfejes.api.auth.Role;
import hu.martinfejes.api.core.AbstractEntity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * Entity to represent {@link User}
 *
 * @author Martin Fejes
 */
@Entity

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "app_user")
@NoArgsConstructor
public class User extends AbstractEntity {

    @NotNull
    @Column(nullable = false)
    String name;

    Email email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Password password;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",
                    referencedColumnName = "id"))
    private List<Role> roles;
}
