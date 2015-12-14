package roulette;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class do unit test for class RouletteView
 * 
 * @author Zhiyuan Li
 * @author Yi Shang
 * 
 */
public class RouletteViewTest {

	/**
	 * instance variable
	 */
	private FrameFixture rv;

	@Before
	public void setUp() {
		rv = new FrameFixture(new RouletteView());
		rv.show();
	}

	@After
	public void tearDown() {
		rv.cleanUp();
	}

	@Test
	public void testDrawButton() {
		rv.button("Spin").click();
		rv.optionPane().requireInformationMessage();
	}

}
