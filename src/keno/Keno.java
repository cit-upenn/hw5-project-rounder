package keno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import javax.print.attribute.standard.NumberUpSupported;

/**
 * This class represents a full Keno table, from 1 - 80.
 * 
 * @author SHANG
 *
 */
public class Keno {

	// instance variables
	private ArrayList<Integer> allNumbers;
	private HashSet<Integer> luckyNumbers;
	private int hits;

	/**
	 * constructor
	 */
	public Keno() {
		allNumbers = new ArrayList<Integer>();
		luckyNumbers = new HashSet<Integer>();
		hits = 0;

		// initialize with 1 - 80
		for (int i = 1; i <= 80; i++) {
			allNumbers.add(i);
		}

	}

	/**
	 * draws 20 numbers out of 80
	 */
	public void drawLuckyNumbers() {
		
		// shuffle all numbers
		Collections.shuffle(allNumbers);
		
		luckyNumbers.clear();

		for (int i = 0; i < 20; i++) {
			luckyNumbers.add(allNumbers.get(i));
		}

	}

	/**
	 * checks if this number hits
	 * 
	 * @return true if it hits
	 */
	public boolean hit(int num) {
		return luckyNumbers.contains(num);
	}

	/**
	 * checks how many numbers this set of numbers hit
	 * 
	 * @param nums
	 *            input numbers
	 * @return number of hits
	 */
	public int numOfHits(HashSet<Integer> nums) {
		hits = 0;
		
		for (Integer i : nums) {
			if (hit(i)) {
				hits++;
			}
		}

		return hits;
	}

	/**
	 * @return the luckyNumbers
	 */
	public HashSet<Integer> getLuckyNumbers() {
		return luckyNumbers;
	}

	/**
	 * calculates the total payout
	 * 
	 * @return the payout
	 */
	public int payout(HashSet<Integer> nums) {
		// calculates number of hits
		numOfHits(nums);

		// the payout depends on how many numbers player picks
		int numOfPicks = nums.size();

		// player can pick 2, 3, 4, 5, 6, 7, 8, 9 or 10 numbers
		switch (numOfPicks) {
		case 2:
			return payoutFor2Picks();
		case 3:
			return payoutFor3Picks();
		case 4:
			return payoutFor4Picks();
		case 5:
			return payoutFor5Picks();
		case 6:
			return payoutFor6Picks();
		case 7:
			return payoutFor7Picks();
		case 8:
			return payoutFor8Picks();
		case 9:
			return payoutFor9Picks();
		case 10:
			return payoutFor10Picks();
		default:
			return 0;
		}

	}

	/**
	 * payout for 2 picks
	 * 
	 * @return the payout
	 */
	private int payoutFor2Picks() {
		switch (hits) {
		case 2:
			return 12;
		default:
			return 0;
		}
	}

	/**
	 * payout for 3 picks
	 * 
	 * @return the payout
	 */
	private int payoutFor3Picks() {
		switch (hits) {
		case 2:
			return 1;
		case 3:
			return 42;
		default:
			return 0;
		}
	}

	/**
	 * payout for 4 picks
	 * 
	 * @return the payout
	 */
	private int payoutFor4Picks() {
		switch (hits) {
		case 2:
			return 1;
		case 3:
			return 3;
		case 4:
			return 130;
		default:
			return 0;
		}
	}

	/**
	 * payout for 5 picks
	 * 
	 * @return the payout
	 */
	private int payoutFor5Picks() {
		switch (hits) {
		case 3:
			return 1;
		case 4:
			return 15;
		case 5:
			return 700;
		default:
			return 0;
		}
	}

	/**
	 * payout for 6 picks
	 * 
	 * @return the payout
	 */
	private int payoutFor6Picks() {
		switch (hits) {
		case 3:
			return 1;
		case 4:
			return 2;
		case 5:
			return 85;
		case 6:
			return 2000;
		default:
			return 0;
		}
	}

	/**
	 * payout for 7 picks
	 * 
	 * @return the payout
	 */
	private int payoutFor7Picks() {
		switch (hits) {
		case 4:
			return 2;
		case 5:
			return 30;
		case 6:
			return 300;
		case 7:
			return 5000;
		default:
			return 0;
		}
	}

	/**
	 * payout for 8 picks
	 * 
	 * @return the payout
	 */
	private int payoutFor8Picks() {
		switch (hits) {
		case 5:
			return 5;
		case 6:
			return 100;
		case 7:
			return 1500;
		case 8:
			return 30000;
		default:
			return 0;
		}
	}

	/**
	 * payout for 9 picks
	 * 
	 * @return the payout
	 */
	private int payoutFor9Picks() {
		switch (hits) {
		case 5:
			return 3;
		case 6:
			return 30;
		case 7:
			return 400;
		case 8:
			return 4000;
		case 9:
			return 40000;
		default:
			return 0;
		}
	}

	/**
	 * payout for 10 picks
	 * 
	 * @return the payout
	 */
	private int payoutFor10Picks() {
		switch (hits) {
		case 5:
			return 1;
		case 6:
			return 10;
		case 7:
			return 100;
		case 8:
			return 1000;
		case 9:
			return 5000;
		case 10:
			return 1000000;
		default:
			return 0;
		}
	}

}
