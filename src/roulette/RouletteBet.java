package roulette;

/**
 * This enum class represents all the possible non-single bet ways in roulette.
 * 
 * @author Zhiyuan Li
 * @author Yi Shang
 *
 */
public enum RouletteBet {
	Red(2), Black(2), Even(2), Odd(2), FirstHalf(2), SecondHalf(2), FirstDozen(3), 
	SecondDozen(3), ThirdDozen(3), FirstColumn(3), SecondColumn(3), ThirdColumn(3);

	// instance variables
	private final int ratio;

	/**
	 * constructor
	 * 
	 * @param ratio
	 */
	private RouletteBet(int ratio) {
		this.ratio = ratio;
	}

	/**
	 * returns the payout ratio
	 * 
	 * @return payout
	 */
	public int getRatio() {
		return ratio;
	}

}
