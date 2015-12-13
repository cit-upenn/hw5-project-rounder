package keno;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class do unit test for class KenoView
 * 
 * @author Zhiyuan Li
 * @author Yi Shang
 * 
 */
public class KenoViewTest {

	private FrameFixture kv;

	@Before
	public void setUp() {
		kv = new FrameFixture(new KenoView());
		kv.show();
	}

	@After
	public void tearDown() {
		kv.cleanUp();
	}

	@Test
	public void testDrawButton() {
		kv.button("Draw").click();
		kv.optionPane().requireInformationMessage();
	}

}
