package learn.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import learn.Mathematics;

class TestMathematicsDistance {

	@Test
	void testDistance1() {
		double x1 = 1.25;
		double y1 = 2.5;
		double x2 = 4.25;
		double y2 = 6.5;
		double d = Mathematics.distance(x1, y1, x2, y2);
		assertEquals(5.0, d);
	}
	
	@Test
	void testDistance2() {
		double x1 = 1.25;
		double y1 = 6.5;
		double x2 = 4.25;
		double y2 = 2.5;
		double d = Mathematics.distance(x1, y1, x2, y2);
		assertEquals(5.0, d);
	}

}
