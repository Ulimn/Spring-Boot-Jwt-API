package hu.martinfejes.api.brand;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import hu.martinfejes.api.core.AbstractEntity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Entity to represent {@link Brand}
 */
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table
@NoArgsConstructor
public class Brand extends AbstractEntity {

    @NotNull
    @Column(nullable = false)
    String name;

    @NotNull
    @Column(nullable = false)
    String nameSlug;
}