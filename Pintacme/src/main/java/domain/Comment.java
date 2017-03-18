
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;


@Entity
@Access(AccessType.PROPERTY)
public class Comment extends DomainEntity {

	
	private int numberOfStars;
	private String text;
	
	public Comment() {
		super();
	}
	
	@Range(min = 0, max = 5)
	public int getNumberOfStars() {
		return numberOfStars;
	}
	public void setNumberOfStars(int numberOfStars) {
		this.numberOfStars = numberOfStars;
	}
	@NotBlank
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	//Relationships
	
	private Painter painter;
	

	@Valid
	@ManyToOne(optional=false)
	public Painter getPainter() {
		return painter;
	}

	public void setPainter(Painter painter) {
		this.painter = painter;
	}
	

	

	
}
