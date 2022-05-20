package validator;

import domain.TicketOrderForm;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TicketFormValidator implements Validator {
		@Override
		public boolean supports(Class<?> klass) {
			return TicketOrderForm.class.isAssignableFrom(klass);
		}

		@Override
		public void validate(Object target, Errors errors) {
			TicketOrderForm ticketOrderForm = (TicketOrderForm) target;

			try {

				Integer code1 = ticketOrderForm.getSoccerCode1();
				Integer code2 = ticketOrderForm.getSoccerCode2();
				Integer tickets = ticketOrderForm.getTickets();


				assert code1 != null && code2 != null;;

				if(code1 > code2){
					 errors.rejectValue(
					"soccerCode1",
					"validation.soccerCode.imbalance",
					"soccerCode1 should be smaller than or equal to soccerCode2"
					 );
					 errors.rejectValue(
					"soccerCode2",
					"validation.soccerCode.imbalance",
							 "soccerCode1 should be smaller than or equal to soccerCode2"
					 );
				}

				assert tickets != null;

				if (tickets > 25) {
					errors.rejectValue(
							"tickets",
							"validation.tickets.max",
							"soccerCode1 should be smaller than or equal to 25");
				  } else if(tickets < 1) {
					errors.rejectValue(
							"tickets",
							"validation.tickets.min",
							"soccerCode1 should be greater than or equal to 1");
				  }

			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
}
