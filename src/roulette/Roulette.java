package roulette;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents a roulette
 * 
 * @author Zhiyuan Li
 * @author Yi Shang
 *
 */
public class Roulette {

	// instance variables
	private ArrayList<RouletteNumber> roulette;
	private Random rand;
	private RouletteNumber roundNumber;

	/**
	 * constructor
	 */
	public Roulette() {
		roulette = new ArrayList<RouletteNumber>();
		rand = new Random();
		setUp();
	}

	/**
	 * adds 0 - 36 numbers into the roulette
	 */
	private void setUp() {
		roulette.add(new RouletteNumber(0, RouletteColor.Green));

		// add 1 - 10
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 1) {
				roulette.add(new RouletteNumber(i, RouletteColor.Red));
			} else {
				roulette.add(new RouletteNumber(i, RouletteColor.Black));
			}
		}

		// add 11 - 18
		for (int i = 11; i <= 18; i++) {
			if (i % 2 == 0) {
				roulette.add(new RouletteNumber(i, RouletteColor.Red));
			} else {
				roulette.add(new RouletteNumber(i, RouletteColor.Black));
			}
		}

		// add 19 - 28
		for (int i = 19; i <= 28; i++) {
			if (i % 2 == 1) {
				roulette.add(new RouletteNumber(i, RouletteColor.Red));
			} else {
				roulette.add(new RouletteNumber(i, RouletteColor.Black));
			}
		}

		// add 29 - 36
		for (int i = 29; i <= 36; i++) {
			if (i % 2 == 0) {
				roulette.add(new RouletteNumber(i, RouletteColor.Red));
			} else {
				roulette.add(new RouletteNumber(i, RouletteColor.Black));
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
	public RouletteNumber getRoundNumber() {
		return roundNumber;
	}

	/**
	 * checks if this bet hits
	 * 
	 * @param n
	 *            player's single bet number
	 * @return true if hit
	 */
	public boolean hitSingle(RouletteNumber n) {
		return roundNumber.getNum() == n.getNum();
	}

	/**
	 * checks if this bet hits
	 * 
	 * @param b
	 *            player's group bet
	 * @return true if hit
	 */
	public boolean hitGroup(RouletteBet b) {

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
	private static RouletteBet buttonIndexToBet(int index) {
		switch (index) {
		case 37:
			return RouletteBet.FirstColumn;// 1stRow(bottom 1st)
		case 38:
			return RouletteBet.SecondColumn;// 2ndRow
		case 39:
			return RouletteBet.ThirdColumn;// 3rdRow
		case 40:
			return RouletteBet.FirstDozen;
		case 41:
			return RouletteBet.SecondDozen;
		case 42:
			return RouletteBet.ThirdDozen;
		case 43:
			return RouletteBet.FirstHalf;
		case 44:
			return RouletteBet.Even;
		case 45:
			return RouletteBet.Red;
		case 46:
			return RouletteBet.Black;
		case 47:
			return RouletteBet.Odd;
		case 48:
			return RouletteBet.SecondHalf;
		default:
			return null;
		}
	}

	/**
	 * Get payout based on input array
	 * 
	 * @return the payout
	 */
	public int getPayout(int[] userBets) {
		int payout = 0;
		
		// calculate all single number payout
		for (int i = 0; i < 37; i++) {
			if (hitSingle(roulette.get(i))) {
				payout += userBets[i] * 36;
			}
		}

		// calculate all bets payout
		for (int i = 37; i < 49; i++) {
			if (hitGroup(buttonIndexToBet(i))) {
				payout += userBets[i] * (buttonIndexToBet(i).getRatio());
			}
		}

		return payout;
	}

}
