package lobby;

import keno.KenoView;
import roulette.RouletteView;
import slot_machine.SlotView;

/**
 * This class will initialize all views for casino games
 * 
 * @author Zhiyuan Li
 * @author Yi Shang
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

		rouletteView = new RouletteView();
		kenoView = new KenoView();
		slotView = new SlotView();
		lobby = new Lobby();

	}

	/**
	 * prints welcome message to users
	 */
	public void start() {
		System.out.println("Game Starts!");
	}

	/**
	 * create new game instance
	 */
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}

}
