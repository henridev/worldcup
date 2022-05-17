package validator;

import domain.SoccerCodes;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SoccerCodesValidation implements Validator {
		@Override
		public boolean supports(Class<?> klass) {
			return SoccerCodes.class.isAssignableFrom(klass);
		}

		@Override
		public void validate(Object target, Errors errors) {
			SoccerCodes numbers = (SoccerCodes) target;

			Integer code1 = numbers.getSoccerCode1();
			Integer code2 = numbers.getSoccerCode2();

			if(code1 == null){
				errors.rejectValue("code1", "{validation.soccerCode.empty}", "code1 is empty");
				return;
			}

			if(code2 == null){
				errors.rejectValue("code2", "{validation.soccerCode.empty}", "code2 is empty");
				return;
			}

			if(code1 >= code2){
      errors.rejectValue(
          "code1", "{validation.soccerCode.imbalance}", "n2 should be smaller than n1");
			}
		}
}
