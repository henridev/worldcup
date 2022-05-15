package domain;

import validator.ValidSoccerCode;

public class SoccerCodes {
	@ValidSoccerCode
	Integer soccerCode1;
	@ValidSoccerCode
	Integer soccerCode2;
	public Integer getSoccerCode1() {
		return soccerCode1;
	}
	public void setSoccerCode1(Integer soccerCode1) {
		this.soccerCode1 = soccerCode1;
	}
	public Integer getSoccerCode2() {
		return soccerCode2;
	}
	public void setSoccerCode2(Integer soccerCode2) {
		this.soccerCode2 = soccerCode2;
	}
}
