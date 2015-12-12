package slot_machine;

import java.util.HashSet;
import java.util.Set;

/**
 * This class represents a Slot Machine game
 * 
 * @author Zhiyuan Li
 * @author Yi Shang
 *
 */
public class Slot {

	// instance variable
	private SlotReel[] reels;
	private SlotSymbol[] symbols;

	// payout ratios
	private final static int DOUBLE_RATIO = 3;
	private final static int TRIPLE_RATIO = 10;

	/**
	 * constructor to set up a slot machine with input number of reels
	 * 
	 * @param numOfReels
	 *            number of reels
	 * 
	 */
	public Slot(int numOfReels) {
		reels = new SlotReel[numOfReels];
		setUpReels();
		symbols = new SlotSymbol[numOfReels];
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
	 * get payout based on input bet
	 * 
	 * @param userBet
	 *            the amount of credits the user bet
	 * @return the payout
	 */
	public int getPayout(int userBet) {
		int payout = 0;
		Set<SlotSymbol> symbolsWithoutDuplicates = new HashSet<SlotSymbol>();
		int duplicates = 0;

		for (SlotSymbol s : symbols) {
			if (symbolsWithoutDuplicates.add(s) == false) {
				duplicates++;
			}
		}
		if (duplicates == 1) {// 2 symbols in common
			payout = userBet * DOUBLE_RATIO;
		} else if (duplicates == 2) {// 3 symbols in common
			payout = userBet * TRIPLE_RATIO;
		} else {
			payout = 0;
		}

		return payout;
	}

	/**
	 * accessor to the symbols
	 * 
	 * @return the symbols
	 */
	public SlotSymbol[] getSymbols() {
		return symbols;
	}

}
