
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Request extends DomainEntity {

	//Constructors====================================================================================

	public Request() {
		super();
	}


	//Attributes=====================================================================================
	private String	priority;
	private String  schedule;
	private String	measures;
	private String description;
	private String address;
	
	
	//Getters & setters================================================================================
	
	@Pattern(regexp = "^LOW$|^MID$|^HIGH$")
	@NotBlank
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	@NotBlank
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	
	@NotBlank
	public String getMeasures() {
		return measures;
	}
	public void setMeasures(String measures) {
		this.measures = measures;
	}
	
	@NotBlank
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@NotBlank
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	//Relationships ====================================================================================
	
	private Customer customer;
	private Collection<Budget> budgets;

	@Valid
	@ManyToOne(optional=false)
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@Valid
	@OneToMany(mappedBy="request")
	public Collection<Budget> getBudgets() {
		return budgets;
	}
	public void setBudgets(Collection<Budget> budgets) {
		this.budgets = budgets;
	}
	
	
	
	

}
