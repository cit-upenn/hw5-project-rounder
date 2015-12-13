package lobby;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class do unit test for class Lobby
 * 
 * @author Zhiyuan Li
 * @author Yi Shang
 * 
 */
public class LobbyTest {

	@Test
	public void testLobbyNotNull() {
		Lobby lobby = new Lobby();
		assertNotNull("KenoView cannot be null", lobby);
	}

}
