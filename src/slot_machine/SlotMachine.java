package slot_machine;

import java.util.HashSet;
import java.util.Set;

/**
 * This class represents a Slot Machine game
 * 
 * @author zhiyuanli
 *
 */
public class SlotMachine {

	// instance variable
	private SlotReel[] reels;
	private SlotSymbol[] symbols;
	private int credits;
	private final static int BASE_RATIO = 5;

	/**
	 * constructor to set up a slot machine with input number of reels and
	 * initial credits the player owns
	 * 
	 * @param numOfReels
	 *            number of reels
	 * @param initialCredits
	 *            initial credits the player owns
	 */
	public SlotMachine(int numOfReels, int initialCredits) {
		reels = new SlotReel[numOfReels];
		setUpReels();
		symbols = new SlotSymbol[numOfReels];
		credits = initialCredits;
	}

	/**
	 * add all reels to the array
	 */
	private void setUpReels() {
		for (int i = 0; i < reels.length; i++) {
			reels[i] = new SlotReel();
		}
	}

	/**
	 * spin the slot machine and get resluts stored in array symbols
	 */
	public void spin() {
		for (int i = 0; i < reels.length; i++) {
			symbols[i] = reels[i].getRandomSymbol();
		}
	}

	/**
	 * helper function to deduct the credits
	 * 
	 * @param amount
	 *            the amount to be deducted
	 */
	private void deductCredits(int amount) {
		credits -= amount;
	}

	/**
	 * get payout based on input bet
	 * 
	 * @param userBet
	 *            the amount of credits the user bet
	 * @return the payout
	 */
	public int getPayout(int userBet) {
		deductCredits(userBet);
		int payout = 0;
		Set<SlotSymbol> symbolsWithoutDuplicates = new HashSet<SlotSymbol>();
		int duplicates = 0;
		for (SlotSymbol s : symbols) {
			if (symbolsWithoutDuplicates.add(s) == false) {
				duplicates++;
			}
		}
		payout = userBet * duplicates * BASE_RATIO;
		credits += payout;
		return payout;
	}

	/**
	 * @return the credits
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * simple test for the slot machine, will be deleted 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SlotMachine sm = new SlotMachine(3, 100);
		for (int i = 0; i < 10; i++) {
			sm.spin();
			for (SlotSymbol s : sm.symbols) {
				System.out.println(s);
			}

			System.out.println(sm.getPayout(1));
			System.out.println(sm.getCredits());
		}
	}

}
