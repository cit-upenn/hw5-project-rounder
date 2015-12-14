package slot_machine;

/**
 * This enum class represents one symbol with its order in slot machine.
 * 
 * @author Zhiyuan Li
 * @author Yi Shang
 *
 */
public enum SlotSymbol {
	Bar(0), Bell(1), Cherry(2), Grape(3), Lemon(4), Seven(5), Watermelon(6);

	/**
	 * instance variable
	 */
	private final int order;

	/**
	 * constructor
	 * 
	 * @param order
	 */
	private SlotSymbol(int order) {
		this.order = order;
	}

	/**
	 * get the order of the symbol
	 * 
	 * @return the order
	 */
	public int getOrder() {
		return order;
	}

}
