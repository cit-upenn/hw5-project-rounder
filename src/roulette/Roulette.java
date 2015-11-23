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

	/**
	 * constructor
	 */
	public Roulette() {
		roulette = new ArrayList<Number>();
		rand = new Random();
		setUp();
	}

	/**
	 * adds 0 - 36 numbers into the roulette
	 */
	private void setUp() {
		roulette.add(new Number(0, Color.Green));

		// add 1 - 10
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 1) {
				roulette.add(new Number(i, Color.Red));
			} else {
				roulette.add(new Number(i, Color.Black));
			}
		}

		// add 11 - 18
		for (int i = 11; i <= 18; i++) {
			if (i % 2 == 0) {
				roulette.add(new Number(i, Color.Red));
			} else {
				roulette.add(new Number(i, Color.Black));
			}
		}

		// add 19 - 28
		for (int i = 19; i <= 28; i++) {
			if (i % 2 == 1) {
				roulette.add(new Number(i, Color.Red));
			} else {
				roulette.add(new Number(i, Color.Black));
			}
		}

		// add 29 - 36
		for (int i = 19; i <= 28; i++) {
			if (i % 2 == 0) {
				roulette.add(new Number(i, Color.Red));
			} else {
				roulette.add(new Number(i, Color.Black));
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

	public static void main(String[] args) {
		Roulette r = new Roulette();
		r.spin();
		System.out.println(r.getRoundNumber());
	}

}
