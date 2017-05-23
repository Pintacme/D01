package domain;

import java.net.URL;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Discussion extends DomainEntity{

	private Date moment;
	private String description;
	private String resolution;
	private Collection<URL> pictures;

	@NotBlank
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Past
	@NotNull
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	@NotBlank
	@Pattern(regexp = "^ACCEPTED$|^PENDING$|^REJECTED$")
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	
	@ElementCollection	
	public Collection<URL> getPictures() {
		return pictures;
	}

	public void setPictures(Collection<URL> pictures) {
		this.pictures = pictures;
	}

	private Request request;

	@OneToOne(optional = false)
	@NotNull
	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	
}
