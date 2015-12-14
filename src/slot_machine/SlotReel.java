package slot_machine;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents one reel in slot machine.
 * 
 * @author Zhiyuan Li
 * @author Yi Shang
 *
 */
public class SlotReel {

	/**
	 * instance variable
	 * reel: slot reel
	 * rand: random number generator
	 */
	private ArrayList<SlotSymbol> reel;
	private Random rand;

	/**
	 * constructor to set up a reel
	 */
	public SlotReel() {
		reel = new ArrayList<SlotSymbol>();
		rand = new Random();
		for (int i = 0; i < SlotSymbol.values().length; i++) {
			reel.add(SlotSymbol.values()[i]);
		}

	}

	/**
	 * The method to generate a random symbol in one reel
	 * 
	 * @return a symbol
	 */
	public SlotSymbol getRandomSymbol() {
		int i = rand.nextInt(reel.size());
		return reel.get(i);
	}

}
