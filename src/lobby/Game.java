package lobby;

import keno.KenoView;
import roulette.RouletteView;
import slot_machine.SlotView;

/**
 * This class will initialize all views for casino games
 * 
 * @author zhiyuanli
 *
 */
public class Game {
	// instance variables
	public static Lobby lobby;
	public static RouletteView rouletteView;
	public static KenoView kenoView;
	public static SlotView slotView;

	/**
	 * constructor to new 4 views, those views will be switched by button
	 * actions
	 */
	public Game() {

		lobby = new Lobby();
		rouletteView = new RouletteView();
		kenoView = new KenoView();
		slotView = new SlotView();

	}

	/*
	 * new game instance
	 */
	public static void main(String[] args) {
		Game game = new Game();
	}

}
