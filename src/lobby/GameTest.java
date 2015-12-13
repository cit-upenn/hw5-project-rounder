package lobby;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
	
	Game game;
	
	@Before
	public void setUp() {
		game = new Game();
	}
	
	@Test
	public void testGameNotNull() {
		assertNotNull("Game cannot be null", game);
	}
	
	@Test
	public void testGameStart() {
		game.start();
		assertNotNull("Game cannot be null after game starts", game);
	}
	
}
