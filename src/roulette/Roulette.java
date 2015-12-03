package roulette;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents a roulette
 * 
 * @author SHANG
 *
 */
public class Roulette {

	// instance variables
	private ArrayList<Number> roulette;
	private Random rand;
	private Number roundNumber;
	private int payout;
	private static final int MAX_NUMBER = 36;

	/**
	 * constructor
	 */
	public Roulette() {
		roulette = new ArrayList<Number>();
		rand = new Random();
		setUp();
		payout = 0;
	}

	/**
	 * adds 0 - 36 numbers into the roulette
	 */
	private void setUp() {
		roulette.add(new Number(0, OwnColor.Green));

		// add 1 - 10
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 1) {
				roulette.add(new Number(i, OwnColor.Red));
			} else {
				roulette.add(new Number(i, OwnColor.Black));
			}
		}

		// add 11 - 18
		for (int i = 11; i <= 18; i++) {
			if (i % 2 == 0) {
				roulette.add(new Number(i, OwnColor.Red));
			} else {
				roulette.add(new Number(i, OwnColor.Black));
			}
		}

		// add 19 - 28
		for (int i = 19; i <= 28; i++) {
			if (i % 2 == 1) {
				roulette.add(new Number(i, OwnColor.Red));
			} else {
				roulette.add(new Number(i, OwnColor.Black));
			}
		}

		// add 29 - 36
		for (int i = 29; i <= 36; i++) {
			if (i % 2 == 0) {
				roulette.add(new Number(i, OwnColor.Red));
			} else {
				roulette.add(new Number(i, OwnColor.Black));
			}
		}

	}

	/**
	 * spins the roulette and outputs the number
	 */
	public void spin() {
		roundNumber = roulette.get(rand.nextInt(37));
	}

	/**
	 * gets the number for this round
	 * 
	 * @return the result
	 */
	public Number getRoundNumber() {
		return roundNumber;
	}

	/**
	 * checks if this bet hits
	 * 
	 * @param n
	 *            player's single bet number
	 * @return true if hit
	 */
	public boolean hitSingle(Number n) {
		return roundNumber.getNum() == n.getNum();
	}

	/**
	 * checks if this bet hits
	 * 
	 * @param b
	 *            player's group bet
	 * @return true if hit
	 */
	public boolean hitGroup(Bet b) {

		switch (b) {
		case Black:
			return roundNumber.isBlack();
		case Red:
			return roundNumber.isRed();
		case Even:
			return roundNumber.isEven();
		case Odd:
			return roundNumber.isOdd();
		case FirstHalf:
			return roundNumber.isFirstHalf();
		case SecondHalf:
			return roundNumber.isSecondHalf();
		case FirstDozen:
			return roundNumber.isFirstDozen();
		case SecondDozen:
			return roundNumber.isSecondDozen();
		case ThirdDozen:
			return roundNumber.isThirdDozen();
		case FirstColumn:
			return roundNumber.isFirstColumn();
		case SecondColumn:
			return roundNumber.isSecondColumn();
		case ThirdColumn:
			return roundNumber.isThirdColumn();
		default:
			return false;
		}

	}

	/**
	 * Transfer button index to Bet
	 * 
	 * @param index
	 * @return
	 */
	private static Bet buttonIndexToBet(int index) {
		switch (index) {
		case 37:
			return Bet.FirstColumn;// 1stRow(bottom 1st)
		case 38:
			return Bet.SecondColumn;// 2ndRow
		case 39:
			return Bet.ThirdColumn;// 3rdRow
		case 40:
			return Bet.FirstDozen;
		case 41:
			return Bet.SecondDozen;
		case 42:
			return Bet.ThirdDozen;
		case 43:
			return Bet.FirstHalf;
		case 44:
			return Bet.Even;
		case 45:
			return Bet.Red;
		case 46:
			return Bet.Black;
		case 47:
			return Bet.Odd;
		case 48:
			return Bet.SecondHalf;
		default:
			return null;
		}
	}

	/**
	 * Get payout based on input array
	 * 
	 * @return the payout
	 */
	public double getPayout(int[] userBets) {
		for (int i = 0; i < userBets.length; i++) {
			if (hitSingle(roulette.get(i))) {
				payout += userBets[i] * 36;
			}
			if (hitGroup(buttonIndexToBet(i))) {
				payout += userBets[i] * (buttonIndexToBet(i).getRatio());
			}
		}

		return payout;
	}

	public static void main(String[] args) {
		Roulette r = new Roulette();
		r.spin();
		System.out.println(r.getRoundNumber());
	}

}
