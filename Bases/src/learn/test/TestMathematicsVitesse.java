package learn.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import learn.Mathematics;

class TestMathematicsVitesse {

	@Test
	void testVitesse() {
		double d = Mathematics.vitesse(20, 5);
		System.out.println(d);
		assertEquals(4.0, d);
	}
	
	@Test
	void testVitesseNegative() {
		double d = Mathematics.vitesse(-20, 5);
		System.out.println(d);
		assertEquals(-4.0, d);
	}
	
	@Test
	void testVitesseTemps0() {
		double d = Mathematics.vitesse(20, 0);
		System.out.println(d);
		assertEquals(Double.POSITIVE_INFINITY, d);
	}
	
	@Test
	void testVitesseDistance0Temps0() {
		double d = Mathematics.vitesse(0, 0);
		System.out.println(d);
		assertTrue(Double.isNaN(d));
	}

}
