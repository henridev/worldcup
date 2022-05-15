package validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SoccerCodeConstraintValidator implements ConstraintValidator<ValidSoccerCode,Integer> {
	@Override
	public void initialize(ValidSoccerCode constraintAnnotation) {}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		return value != null && value >= 1 && value <= 25 ;
	}
}