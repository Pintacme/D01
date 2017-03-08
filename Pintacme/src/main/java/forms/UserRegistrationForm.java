package forms;

import javax.persistence.Column;
import javax.validation.constraints.Size;

import utilities.validators.AlwaysTrue;
import utilities.validators.MatchPasswords;

@MatchPasswords
public class UserRegistrationForm {

	private String username;
	private String password;
	private String verifyPassword;

	private Boolean acceptTerms;

	@Size(min = 5, max = 32)
	@Column(unique = true)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	@Size(min = 5, max = 32)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Size(min = 5, max = 32)
	public String getVerifyPassword() {
		return verifyPassword;
	}
	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	@AlwaysTrue
	public Boolean getAcceptTerms() {
		return acceptTerms;
	}

	public void setAcceptTerms(Boolean acceptTerms) {
		this.acceptTerms = acceptTerms;
	}

}