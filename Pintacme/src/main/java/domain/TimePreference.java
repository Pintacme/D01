package domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;

@Embeddable
@Access(AccessType.PROPERTY)
public class TimePreference extends DomainEntity{
		
	// Constructors -----------------------------------------------------------
	public TimePreference(){
		super();
	}
	
	
	// Values -----------------------------------------------------------------
	public static final String	MORNING		= "MORNING";
	public static final String	AFTERNOON	= "AFTERNOON";


	// Attributes -------------------------------------------------------------
	private String timePreference;
	
	// Methods ----------------------------------------------------------------
	
	@NotBlank
	@SafeHtml(whitelistType = WhiteListType.NONE)
	public String getTimePreference() {
		return this.timePreference;
	}

	public void setTimePreference(String timePreference) {
		this.timePreference = timePreference;
	}
	

	public static Collection<TimePreference> listTimePreference() {
		Collection<TimePreference> result;
		TimePreference timePreference;

		result = new ArrayList<TimePreference>();

		timePreference = new TimePreference();
		timePreference.setTimePreference(MORNING);
		result.add(timePreference);

		timePreference = new TimePreference();
		timePreference.setTimePreference(AFTERNOON);
		result.add(timePreference);

		return result;
	}

	
	// Relationships ----------------------------------------------------------
}

