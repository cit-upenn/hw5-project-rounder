package roulette;

/**
 * This class represents one single Roulette number. 
 * Range: [0, 36] 
 * Color: 
 * 1. Green - 0 
 * 2. Red - 1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36 
 * 3. Black - 2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35
 * 
 * @author Zhiyuan Li
 * @author Yi Shang
 *
 */
public class RouletteNumber {

	// instance variables
	private final int num;
	private final RouletteColor color;

	/**
	 * constructor
	 * 
	 * @param num
	 *            number value
	 * @param color
	 *            number color
	 */
	public RouletteNumber(int num, RouletteColor color) {
		this.num = num;
		this.color = color;
	}

	/**
	 * @return the number
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @return the color
	 */
	public RouletteColor getColor() {
		return color;
	}

	/**
	 * checks if it's zero
	 * 
	 * @return true if it's zero
	 */
	public boolean isZero() {
		return num == 0;
	}

	/**
	 * checks if it's odd number
	 * 
	 * @return true if it's odd
	 */
	public boolean isOdd() {
		return num % 2 == 1;
	}

	/**
	 * checks if it's even number
	 * 
	 * @return true if it's even
	 */
	public boolean isEven() {
		return num != 0 && num % 2 == 0;
	}

	/**
	 * checks if it's Red
	 * 
	 * @return true if it's Red
	 */
	public boolean isRed() {
		return color == RouletteColor.Red;
	}

	/**
	 * checks if it's Black
	 * 
	 * @return true if it's Black
	 */
	public boolean isBlack() {
		return color == RouletteColor.Black;
	}

	/**
	 * checks if it's Green
	 * 
	 * @return true if it's Green
	 */
	public boolean isGreen() {
		return color == RouletteColor.Green;
	}

	/**
	 * checks if it's 1 - 18
	 * 
	 * @return true if it's 1 - 18
	 */
	public boolean isFirstHalf() {
		return num >= 1 && num <= 18;
	}

	/**
	 * checks if it's 19 - 36
	 * 
	 * @return true if it's 19 - 36
	 */
	public boolean isSecondHalf() {
		return num >= 19 && num <= 36;
	}

	/**
	 * checks if it's 1 - 12
	 * 
	 * @return true if it's 1 - 12
	 */
	public boolean isFirstDozen() {
		return num >= 1 && num <= 12;
	}

	/**
	 * checks if it's 13 - 24
	 * 
	 * @return true if it's 13 - 24
	 */
	public boolean isSecondDozen() {
		return num >= 13 && num <= 24;
	}

	/**
	 * checks if it's 25 - 36
	 * 
	 * @return true if it's 25 - 36
	 */
	public boolean isThirdDozen() {
		return num >= 25 && num <= 36;
	}

	/**
	 * checks if it's first column
	 * 
	 * @return true if so
	 */
	public boolean isFirstColumn() {
		return num % 3 == 1;
	}

	/**
	 * checks if it's second column
	 * 
	 * @return true if so
	 */
	public boolean isSecondColumn() {
		return num% 3 == 2;
	}

	/**
	 * checks if it's third column
	 * 
	 * @return true if so
	 */
	public boolean isThirdColumn() {
		return num % 3 == 0;
	}
	
	@Override
	public String toString() {
		return "(" + num + ", " + color + ")";
	}

}
