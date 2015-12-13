package slot_machine;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class SlotTest {
	
	private Slot slot;

	@Before
	public void setUp() {
		slot = new Slot(3);
	}

	@Test
	public void testSpinResult() {
		slot.spin();
		for (int i = 0; i < slot.getSymbols().length; i++) {
			assertNotNull("Symbols should not be null", slot.getSymbols()[i]);
		}
	}

	@Test
	public void testPayout() {
		int duplicates = 0;
		slot.spin();
		Set<SlotSymbol> symbolsWithoutDuplicates = new HashSet<SlotSymbol>();
		
		for (SlotSymbol s : slot.getSymbols()) {
			if (symbolsWithoutDuplicates.add(s) == false) {
				duplicates++;
			}
		}
		
		if (duplicates == 1) {// 2 symbols in common
			assertEquals(3, slot.getPayout(1));
		} else if (duplicates == 2) {// 3 symbols in common
			assertEquals(10, slot.getPayout(1));
		} else {
			assertEquals(0, slot.getPayout(1));
		}
		
	}

}
