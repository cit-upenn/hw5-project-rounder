package keno;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class KenoTest {
	
	private Keno k;
	
	@Before
	public void setUp() {
		k = new Keno();	
	}

	@Test
	public void testKenoNotNull() {
		assertNotNull("Keno cannot be null", k);
	}

	@Test
	public void testHitNotZero() {
		assertFalse("0 cannot hit", k.hit(0));
	}
	
	@Test
	public void testDrawLuckyNumbers() {
		k.drawLuckyNumbers();
		assertEquals("Should contain 20 numbers", 20, k.getLuckyNumbers().size());
	}
	
	@Test
	public void testNumOfHits() {
		HashSet<Integer> nums = new HashSet<Integer>();
		for (int i = 1; i <= 80; i++) {
			nums.add(i);
		}
		k.drawLuckyNumbers();
		assertEquals("Should hit 20", 20, k.numOfHits(nums));
	}

	@Test
	public void testPayout() {
		k.drawLuckyNumbers();
		HashSet<Integer> nums = new HashSet<Integer>();
		assertEquals("Pick 0, should pay 0", 0, k.payout(nums));
		nums.add(0);
		assertEquals("Pick 1, should pay 0", 0, k.payout(nums));
		nums.add(-1);
		assertEquals("Pick 2, should pay 0", 0, k.payout(nums));
		nums.add(-2);
		assertEquals("Pick 3, should pay 0", 0, k.payout(nums));
		nums.add(-3);
		assertEquals("Pick 4, should pay 0", 0, k.payout(nums));
		nums.add(-4);
		assertEquals("Pick 5, should pay 0", 0, k.payout(nums));
		nums.add(-5);
		assertEquals("Pick 6, should pay 0", 0, k.payout(nums));
		nums.add(-6);
		assertEquals("Pick 7, should pay 0", 0, k.payout(nums));
		nums.add(-7);
		assertEquals("Pick 8, should pay 0", 0, k.payout(nums));
		nums.add(-8);
		assertEquals("Pick 9, should pay 0", 0, k.payout(nums));
		nums.add(-9);
		assertEquals("Pick 10, should pay 0", 0, k.payout(nums));
	}
	
}
