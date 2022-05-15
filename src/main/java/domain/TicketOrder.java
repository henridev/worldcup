package domain;

import org.springframework.format.annotation.NumberFormat;
import validator.ValidSoccerCode;

import javax.validation.constraints.NotNull;

public class TicketOrder {
	@NotNull
	private String email;
	@NotNull
	private Integer ticket;
	@ValidSoccerCode
	@NumberFormat(pattern = "##")
	private Integer soccerCode1 = 1;
	@ValidSoccerCode
	@NumberFormat(pattern = "##")
	private Integer soccerCode2 = 1;

	public String getEmail() {
		return email;
	}
	public int getTickets() {
		return ticket;
	}
	public int getSoccerCode1() {
		return soccerCode1;
	}
	public int getSoccerCode2() {
		return soccerCode2;
	}
}
