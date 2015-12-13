package roulette;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class do unit test for class RouletteTest
 * 
 * @author Zhiyuan Li
 * @author Yi Shang
 * 
 */

public class RouletteBetTest {

	@Test
	public void testRouletteBet() {
		assertEquals("Red return 2", 2, RouletteBet.Red.getRatio());
		assertEquals("Black return 2", 2, RouletteBet.Black.getRatio());
		assertEquals("Odd return 2", 2, RouletteBet.Odd.getRatio());
		assertEquals("Even return 2", 2, RouletteBet.Even.getRatio());
		assertEquals("1st half return 2", 2, RouletteBet.FirstHalf.getRatio());
		assertEquals("2nd half return 2", 2, RouletteBet.SecondHalf.getRatio());
		assertEquals("1st dozen return 3", 3, RouletteBet.FirstDozen.getRatio());
		assertEquals("2nd dozen return 3", 3, RouletteBet.SecondDozen.getRatio());
		assertEquals("3rd dozen return 3", 3, RouletteBet.ThirdDozen.getRatio());
		assertEquals("1st column return 3", 3, RouletteBet.FirstColumn.getRatio());
		assertEquals("2nd column return 3", 3, RouletteBet.SecondColumn.getRatio());
		assertEquals("3rd column return 3", 3, RouletteBet.ThirdColumn.getRatio());
	}

}
