package lobby;

import static org.junit.Assert.*;

import org.junit.Test;

public class LobbyTest {

	@Test
	public void testLobbyNotNull() {
		Lobby lobby = new Lobby();
		assertNotNull("KenoView cannot be null", lobby);
	}

}
