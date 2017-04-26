package domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

@Embeddable
@Access(AccessType.PROPERTY)
public class Genre extends DomainEntity{
		
	// Constructors -----------------------------------------------------------
	public Genre(){
		super();
	}
	
	
	// Values -----------------------------------------------------------------
	public static final String	MAN		= "MAN";
	public static final String	WOMAN	= "WOMAN";


	// Attributes -------------------------------------------------------------
	private String genre;
	
	// Methods ----------------------------------------------------------------
	@NotBlank
	public String getGenre() {
		return this.genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public static Collection<Genre> listGenre() {
		Collection<Genre> result;
		Genre genre;

		result = new ArrayList<Genre>();

		genre = new Genre();
		genre.setGenre(MAN);
		result.add(genre);

		genre = new Genre();
		genre.setGenre(WOMAN);
		result.add(genre);

		return result;
	}
	
	// Relationships ----------------------------------------------------------
}

