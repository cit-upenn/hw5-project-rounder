package slot_machine;

import static org.junit.Assert.*;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;

public class SlotViewTest {

	private SlotView slotview;
	private JButton spin;

	@Before
	public void setUp() {
		slotview = new SlotView();
	}

	@Test
	public void testSlotViewNotNull() {
		assertNotNull("slotview should not be null", slotview);
	}

}
