package roulette;

import static org.junit.Assert.*;

import org.junit.Test;

public class RouletteNumberTest {

	@Test
	public void testColor() {
		assertEquals("1 should be red", RouletteColor.Red, new RouletteNumber(1, RouletteColor.Red).getColor());
	}

	@Test
	public void testZero() {
		assertTrue("0 should be 0", new RouletteNumber(0, RouletteColor.Green).isZero());
	}
	
	@Test
	public void testOdd() {
		assertTrue("1 should be odd", new RouletteNumber(1, RouletteColor.Red).isOdd());
	}

	@Test
	public void testEven() {
		assertTrue("2 should be even", new RouletteNumber(2, RouletteColor.Black).isEven());
	}

	@Test
	public void testRed() {
		assertTrue("1 should be red", new RouletteNumber(1, RouletteColor.Red).isRed());
	}

	@Test
	public void testBlack() {
		assertTrue("2 should be black", new RouletteNumber(2, RouletteColor.Black).isBlack());
	}

	@Test
	public void testGreen() {
		assertTrue("0 should be green", new RouletteNumber(0, RouletteColor.Green).isGreen());
	}

	@Test
	public void testFirstHalf() {
		assertTrue("1 should be 1st half", new RouletteNumber(1, RouletteColor.Red).isFirstHalf());
	}

	@Test
	public void testSecondHalf() {
		assertTrue("36 should be 2nd half", new RouletteNumber(36, RouletteColor.Red).isSecondHalf());
	}

	@Test
	public void testFirstDozen() {
		assertTrue("1 should be 1st dozen", new RouletteNumber(1, RouletteColor.Red).isFirstDozen());
	}

	@Test
	public void testSecondDozen() {
		assertTrue("16 should be 2nd dozen", new RouletteNumber(16, RouletteColor.Red).isSecondDozen());
	}
	
	@Test
	public void testThirdDozen() {
		assertTrue("36 should be 3rd dozen", new RouletteNumber(36, RouletteColor.Red).isThirdDozen());
	}

	@Test
	public void testFirstColumn() {
		assertTrue("1 should be 1st column", new RouletteNumber(1, RouletteColor.Red).isFirstColumn());
	}

	@Test
	public void testSecondColumn() {
		assertTrue("2 should be 2nd column", new RouletteNumber(2, RouletteColor.Black).isSecondColumn());
	}
	
	@Test
	public void testThirdColumn() {
		assertTrue("3 should be 3rd column", new RouletteNumber(3, RouletteColor.Red).isThirdColumn());
	}
	
	@Test
	public void testToString() {
		assertNotNull("String should not be null", new RouletteNumber(1, RouletteColor.Red).toString());
	}
	
}
