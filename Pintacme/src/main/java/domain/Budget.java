
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Budget extends DomainEntity {

	//Constructors====================================================================================

	public Budget() {
		super();
	}


	//Attributes=====================================================================================
	private String	status;
	private double	amount;
	private String	description;


	//Getters & setters================================================================================
	@Pattern(regexp = "^ACCEPTED$|^PENDING$|^REJECTED$")
	@NotBlank
	public String getStatus() {
		return this.status;
	}

	public void setStatus(final String status) {
		this.status = status;
	}

	@Min(1)
	@Digits(integer = 99, fraction = 2)
	public double getAmount() {
		return this.amount;
	}

	public void setAmount(final double amount) {
		this.amount = amount;
	}

	@NotBlank
	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	//Relationships ====================================================================================

}
