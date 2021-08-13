package br.com.sortdices.program;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import br.com.sortdices.entity.Dice;

public class Calc {
	
	private static Long tries = 0L;
	
	private static final short NUMBER_DICES = 5;
	private static final short SIDE_DICE = 20;
	
	public static void main(String[] args) {
		
		BigDecimal init = new BigDecimal(System.currentTimeMillis());
		List<Dice> dices = new ArrayList<>();

		startGame(dices);
		
		printTime(init);
	}

	private static void startGame(List<Dice> dices) {
		
		do {
			dices.clear();
			for (short i = 1; i <= NUMBER_DICES; i++) {
				
				Dice newDice = new Dice(SIDE_DICE);
				newDice.setValue(getRandomValueDice(newDice));
				dices.add(newDice);
			}
			printDices(dices);
			tries++;
		} while (!checkEqualsDices(dices));
	}

	private static void printTime(BigDecimal init) {
		System.out.println(tries + " tried, in " + (new BigDecimal(System.currentTimeMillis()).subtract(init).divide(new BigDecimal(1000))) + " s");
	}

	private static void printDices(List<Dice> dices) {
		System.out.println("Dices: " +
				Arrays.toString(dices.stream().map(Dice::getValue).collect(Collectors.toList()).toArray()));
	}

	private static Integer getRandomValueDice(Dice dice) {
		try {
			return SecureRandom.getInstance("SHA1PRNG").nextInt(dice.getSides()) + 1;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static boolean checkEqualsDices(List<Dice> dices) {
		return dices.stream().allMatch(e -> e.getValue().equals(dices.get(0).getValue()));
	}

}
