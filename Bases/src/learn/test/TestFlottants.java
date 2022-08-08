package learn.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Nombres à virgule flottante
 * https://fr.wikipedia.org/wiki/IEEE_754
 *
 */
class TestFlottants {

	@Test
	void test() {
		double temperature1 = 33.2;
		float temperature2 = 24.3F;
		System.out.println(temperature1);
		System.out.println(temperature2);
	}
	
	@Test
	void testRangeFlottants() {
		double grand = 3.14E80;
		double petit = 3.14E-80;
		System.out.println(grand);
		System.out.println(petit);
		grand = 1.1E308;
		System.out.println(grand);
		double tresGrand = grand * 2;
		System.out.println(tresGrand); // +Inf
		System.out.println(Double.POSITIVE_INFINITY);
		System.out.println(Double.NEGATIVE_INFINITY);
		System.out.println(Double.NaN); // Not A Number
	}
	
	@Test
	void testNaN() {
		double nan = Double.NaN;
		double x = nan * 2;
		System.out.println(x);
	}

	@Test
	void testOperator() {
		double x = 13.2;
		double y = 4.1;
		double z = x / y;
		System.out.println(z);
	}
	
	@Test
	void testDivisionEntiersResultatFlottant() {
		int x = 13;
		int y = 4;
		double z = x / y;
		System.out.println(z);
		z = x / (double) y;
		System.out.println(z);
		z = x / 4.0;
		System.out.println(z);
	}
	
	@Test
	void testMath() {
		System.out.println(Math.PI);
		double x = Math.pow(2, 31) - 1;
		System.out.println(x);
		x = Math.sqrt(900);
		System.out.println(x);
	}
	
	@Test
	void testOperateurComparaison() {
		double x = 3.25;
		boolean test = x == 3.25;
		System.out.println(test);
		System.out.println(x == 3.24);
		test = true; // false
		System.out.println(x != 20.3);
		System.out.println(x < 5);
		System.out.println(x <= 5.0);
	}
}
