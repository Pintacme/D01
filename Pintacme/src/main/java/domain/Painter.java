
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class Painter extends Actor {

	private String	code;
	private int		averageStart;


	public Painter() {
		super();
	}

	@NotNull
	public String getCode() {
		return this.code;
	}

	public void setCode(final String code) {
		this.code = code;
	}

	@NotNull
	public int getAverageStart() {
		return this.averageStart;
	}

	public void setAverageStart(final int averageStart) {
		this.averageStart = averageStart;
	}

}
