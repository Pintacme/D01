
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;



@Entity
@Access(AccessType.PROPERTY)
public class Customer extends Actor {

	

	private String dni;
	private CreditCard creditCard;

	public Customer() {
		super();
	}
	
	@NotNull
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	@NotNull
	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	
}