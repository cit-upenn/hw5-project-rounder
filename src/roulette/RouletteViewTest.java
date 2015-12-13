package roulette;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RouletteViewTest {

	private RouletteView rv;
	
	@Before
	public void setUp() {
		rv = new RouletteView();
	}

	@Test
	public void testRouletteViewNotNull() {
		assertNotNull("KenoView cannot be null", rv);
	}
	
	@Test
	public void testTotalBets() {
		assertEquals("Total bets should be 0", 0, rv.getTotalBets());
	}

}
