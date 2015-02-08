package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSum {
Sum s = new Sum();
	@Test
	public void test() {
		//fail("Not yet implemented");
		//assertTrue(s.sum(5, 5)==11 );
		assertEquals("", 10, s.sum(5, 5));
		assertEquals("", 1, s.del(5, 0));
	}
	


}
