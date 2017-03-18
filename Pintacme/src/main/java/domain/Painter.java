
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
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

	
	//RELATIONSHIPS
	
	Collection<Budget> budgets;
	Collection<Comment> comments;
	private Curriculum curriculum;

	@Valid
	@OneToMany(mappedBy="painter")
	public Collection<Budget> getBudgets() {
		return budgets;
	}

	public void setBudgets(Collection<Budget> budgets) {
		this.budgets = budgets;
	}

	@Valid
	@OneToMany(mappedBy="painter")
	public Collection<Comment> getComments() {
		return comments;
	}

	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}

	@Valid
	@OneToOne(optional=true)
	public Curriculum getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}
	
	
	
	
	
	
}
