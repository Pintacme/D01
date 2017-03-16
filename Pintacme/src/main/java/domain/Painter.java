
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Access(AccessType.PROPERTY)
public class Painter extends Actor {

	
	private String code;
	private int averageStart;
	
	

	public Painter() {
		super();
	}
	
	@NotBlank
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@NotNull
	public int getAverageStart() {
		return averageStart;
	}

	public void setAverageStart(int averageStart) {
		this.averageStart = averageStart;
	}
	

	
}
