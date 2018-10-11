/**
 * 
 */
package hu.martinfejes.api.core;

import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.hateoas.Identifiable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Base class for the entities. Has a {@link Long} id.
 *
 * @author Martin Fejes
 */
@MappedSuperclass
@Getter
@ToString
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Identifiable<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private final Long id;

	@Version
	private Long version;

	@CreatedDate
	private Date createdDate;

	@CreatedBy
	private String createdBy;

	@LastModifiedDate
	private Date lastModifiedDate;

	@LastModifiedBy
	private String modifiedBy;

	protected AbstractEntity() {
		this.id = null;
	}
}
