package domain;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

public class TicketOrderForm implements Serializable {

	@NotEmpty
	@Email(message = "{validation.email.valid}")
	private String email;
	@NotNull
	@NumberFormat(pattern = "##")
	private Integer tickets;
	@NotNull
	Integer soccerCode1;
	@NotNull
	Integer soccerCode2;

	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public Integer getTickets() {
		return tickets;
	}
	public void setTickets(Integer tickets) {
		this.tickets = tickets;
	}

	public Integer getSoccerCode1() {
		return soccerCode1;
	}
	public Integer getSoccerCode2() {
		return soccerCode2;
	}
	public void setSoccerCode1(Integer code) {
		this.soccerCode1 = code;
	}
	public void setSoccerCode2(Integer code) {
		this.soccerCode2 = code;
	}

	@Override
	public String toString() {
		return "TicketOrderForm{" +
				"email='" + email + '\'' +
				", tickets=" + tickets +
				", soccerCode1=" + soccerCode1 +
				", soccerCode2=" + soccerCode2 +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TicketOrderForm that = (TicketOrderForm) o;
		return Objects.equals(email, that.email) && Objects.equals(tickets, that.tickets) && Objects.equals(soccerCode1, that.soccerCode1) && Objects.equals(soccerCode2, that.soccerCode2);
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, tickets, soccerCode1, soccerCode2);
	}
}
