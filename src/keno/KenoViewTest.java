package keno;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KenoViewTest {

	private KenoView kv;
	
	@Before
	public void setUp() {
		kv = new KenoView();
	}

	@Test
	public void testKenoViewNotNull() {
		assertNotNull("KenoView cannot be null", kv);
	}
	
}
