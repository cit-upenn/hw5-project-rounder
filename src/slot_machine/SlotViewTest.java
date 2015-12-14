package slot_machine;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SlotViewTest {
	
	/**
	 * instance variable
	 */
	private FrameFixture slot;

	@Before
	public void setUp() {
		slot = new FrameFixture(new SlotView());
		slot.show();
	}

	@After
	public void tearDown() {
		slot.cleanUp();
	}

	@Test
	public void testSpinButton() throws InterruptedException {
		slot.button("Spin").click();
		Thread.sleep(5000);
		slot.optionPane().requireInformationMessage();
	}

}
