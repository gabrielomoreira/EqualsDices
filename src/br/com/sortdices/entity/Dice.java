package br.com.sortdices.entity;

public class Dice {

	private Short sides;
	private Integer value;

	public Dice(Short sides) {
		this.sides = sides;
	}
	
	public Dice(Integer diceValue) {
		this.value = diceValue;
	}
	
	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	public Short getSides() {
		return sides;
	}
	
}
