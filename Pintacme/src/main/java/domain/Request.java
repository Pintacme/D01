
package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;
import org.springframework.format.annotation.DateTimeFormat;

import utilities.validators.AllURLs;


@Entity
@Access(AccessType.PROPERTY)
public class Request extends DomainEntity {

	//Constructors====================================================================================

	public Request() {
		super();
	}


	//Attributes=====================================================================================
	private String  schedule;
	private String	measures;
	private String description;
	private String address;
	private Date moment;
	private Date work;
	private Collection<String> photos;
	
	
	//Getters & setters================================================================================
	
	@NotBlank
	@SafeHtml(whitelistType = WhiteListType.NONE)
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	
	@NotBlank
	@SafeHtml(whitelistType = WhiteListType.NONE)
	public String getMeasures() {
		return measures;
	}
	public void setMeasures(String measures) {
		this.measures = measures;
	}
	
	@NotBlank
	@SafeHtml(whitelistType = WhiteListType.NONE)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@NotBlank
	@SafeHtml(whitelistType = WhiteListType.NONE)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Past
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="dd/MM/yyyy HH:mm")
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="dd/MM/yyyy HH:mm")
	public Date getWork() {
		return work;
	}
	public void setWork(Date work) {
		this.work = work;
	}

	@AllURLs
	@ElementCollection
	public Collection<String> getPhotos() {
		return this.photos;
	}
	public void setPhotos(Collection<String> photos) {
		this.photos = photos;
	}
	

	//Relationships ====================================================================================
	

	private Customer customer;
	private Collection<Budget> budgets;
	private Discussion discussion;

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
	
	@OneToOne(cascade = CascadeType.ALL, optional= true)
	@Valid
	public Discussion getDiscussion() {
		return discussion;
	}
	public void setDiscussion(Discussion discussion) {
		this.discussion = discussion;
	}
	
	
	
	

}
