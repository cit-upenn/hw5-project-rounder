package slot_machine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SlotReelTest {
	private SlotReel reel;

	@Before
	public void setUp() {
		reel = new SlotReel();
	}

	@Test
	public void testRandomSymbol() {
		assertTrue("Random symbol should be a SlotSymbol", reel.getRandomSymbol() instanceof SlotSymbol);
	}

}
