
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;



@Entity
@Access(AccessType.PROPERTY)
public class Customer extends Actor {

	

	private String dni;
	private CreditCard creditCard;

	public Customer() {
		super();
	}
	
	@NotBlank
	@SafeHtml(whitelistType = WhiteListType.NONE)
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	@Valid
	@NotNull
	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	
	//RELATIONSHIPS
	
	private Collection<Request> requests;

	@Valid
	@OneToMany(mappedBy="customer")
	public Collection<Request> getRequests() {
		return requests;
	}


	public void setRequests(Collection<Request> requests) {
		this.requests = requests;
	}
	
	

	
}