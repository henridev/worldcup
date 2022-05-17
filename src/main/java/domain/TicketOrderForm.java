package domain;

import org.springframework.format.annotation.NumberFormat;
import validator.ValidEmail;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TicketOrderForm {
	@NotEmpty
	@ValidEmail
	private String email;
	@NotNull
	@NumberFormat(pattern = "##")
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
	public void setSoccerCode1(Integer code) {
		soccerCodes.setSoccerCode1(code);
	}
	public void setSoccerCode2(Integer code) {
		soccerCodes.setSoccerCode2(code);
	}
}
