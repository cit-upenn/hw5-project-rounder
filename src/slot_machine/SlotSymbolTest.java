package slot_machine;

import static org.junit.Assert.*;

import org.junit.Test;

public class SlotSymbolTest {

	@Test
	public void testOrderIsCorrect() {
		for (int i = 0; i < SlotSymbol.values().length; i++) {
			assertEquals(SlotSymbol.values()[i] + "'s order is not correct!", i, SlotSymbol.values()[i].getOrder());
		}
	}

}
