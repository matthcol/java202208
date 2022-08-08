package learn.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import learn.Mathematics;

class TestMathematicsDistance {

	@Test
	void testDistanceDeltaPositif() {
		double x1 = 1.25;
		double y1 = 2.5;
		double x2 = 4.25;
		double y2 = 6.5;
		double d = Mathematics.distance(x1, y1, x2, y2);
		assertEquals(5.0, d);
	}
	
	@Test
	void testDistanceDeltaNegative() {
		double x1 = 1.25;
		double y1 = 6.5;
		double x2 = 4.25;
		double y2 = 2.5;
		double d = Mathematics.distance(x1, y1, x2, y2);
		assertEquals(5.0, d);
	}

	@ParameterizedTest
	@ValueSource(doubles={1, 1E-3, 1E3, 1E100, 1E300})
	void testDistanceDeltaRange(double scale) {
		double x1 = 1.25*scale;
		double y1 = 6.5*scale;
		double x2 = 4.25*scale;
		double y2 = 2.5*scale;
		double d = Mathematics.distance(x1, y1, x2, y2);
		assertEquals(5.0*scale, d);
	}
}
