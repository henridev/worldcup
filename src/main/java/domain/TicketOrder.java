package domain;

import org.springframework.format.annotation.NumberFormat;
import validator.ValidSoccerCode;

import javax.validation.constraints.NotNull;

public class TicketOrder {
	@NotNull
	private String email;
	@NotNull
	private Integer ticket;
	private SoccerCodes soccerCodes;

	public String getEmail() {
		return email;
	}
	public int getTickets() {
		return ticket;
	}
	public SoccerCodes getSoccerCodes() {
		return soccerCodes;
	}

	public int getSoccerCode1() {
		return soccerCodes.getSoccerCode1();
	}
	public int getSoccerCode2() {
		return soccerCodes.getSoccerCode2();
	}
	public int setSoccerCode1() {
		return soccerCodes.getSoccerCode1();
	}
	public int setSoccerCode2() {
		return soccerCodes.getSoccerCode2();
	}
}
