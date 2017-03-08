package utilities.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import forms.UserRegistrationForm;

public class MatchPasswordsValidator implements ConstraintValidator<MatchPasswords, UserRegistrationForm> {

	@Override
	public void initialize(MatchPasswords constraintAnnotation) {

	}

	@Override
	public boolean isValid(UserRegistrationForm urf, ConstraintValidatorContext cvc) {

		return urf.getPassword().equals(urf.getVerifyPassword());
	}
}