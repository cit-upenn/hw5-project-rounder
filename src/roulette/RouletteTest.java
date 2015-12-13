package roulette;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * This class do unit test for class Roulette
 * 
 * @author Zhiyuan Li
 * @author Yi Shang
 * 
 */
public class RouletteTest {
	
	private Roulette roulette;

	@Before
	public void setUp() {
		roulette = new Roulette();
	}
	
	@Test
	public void testRouletteNotNull() {
		assertNotNull("Roulette cannot be null", roulette);
	}	

	@Test
	public void testSpin() {
		roulette.spin();
		int num = roulette.getRoundNumber().getNum();
		assertTrue("Number should be between 0 and 36", num >= 0 && num <= 36);
	}
	
	@Test
	public void testHitSingle() {
		roulette.spin();
		assertFalse("37 should not hit", roulette.hitSingle(new RouletteNumber(37, RouletteColor.Red)));
	}	

}
