package learn.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestNombre {

	@Test
	void testEntier() {
		int jour = 8;
		short mois = 7;
		long annee = 2022;
		System.out.println("Jour du mois : " + jour);
		System.out.println("Mois : " + mois);
		System.out.println("Année : " + annee);
	}
	
	@Test
	void testRangeInt() {
		// int : 32 bits ~ milliard
		int xMax = 2000000000;
		int xMin = -2000000000;
		System.out.println(xMin + " à " + xMax);
		xMin = Integer.MIN_VALUE;
		xMax = Integer.MAX_VALUE;
		System.out.println(xMin + " à " + xMax);
	}
	
	@Test
	void testRangeShort() {
		// short : 16 bits
		short xMax = 32180;
		short xMin = -32000;
		System.out.println(xMin + " à " + xMax);
		xMin = Short.MIN_VALUE;
		xMax = Short.MAX_VALUE;
		System.out.println(xMin + " à " + xMax);
	}
	
	@Test
	void testRangeLong() {
		// long : 64 bits ~ milliard de milliard
		long xMax = 4000000000L;
		long xMin = -32000;
		System.out.println(xMin + " à " + xMax);
		xMin = Long.MIN_VALUE;
		xMax = Long.MAX_VALUE;
		System.out.println(xMin + " à " + xMax);
	}
	
	@Test
	void testConversion() {
		short xs;
		int xi;
		long xl;
		// plus grand peut toujours recevoir le plus petit
		xs = 12;
		xi = xs;
		xl = xs;
		xl = xi;
		// sens inverse (OK)
		xi = (int) xl;
		xs = (short) xi;
		xs = (short) xl;
		System.out.println(xs + ", " + xi + ", " +xl);
		// sens inverse (NOK) : perte d'information
		xl = 3000000000L;
		xi = (int) xl;
		xs = (short) xl;
		System.out.println(xs + ", " + xi + ", " +xl);
	}
	
	@Test
	void testEffetModulo() {
		int x = Integer.MAX_VALUE;
		System.out.println(x);
		x = x + 1;
		System.out.println(x);
	}
	
	@Test
	void testOperateurMath() {
		int x = 4;
		int y = (x + 3) * 2 - 1;
		System.out.println("y = " + y);
		// division entiere : quotient
		int z = y / x; // 13 / 4 => 3
		int r = y % x; // reste de la division
		System.out.println("z = " + z);
		System.out.println("r = " + r);
	}
	
	@Test
	void testOperateurInplace() {
		int x = 4;
		x++;
		System.out.println(x);
		++x;
		System.out.println("x = " + x);
		System.out.println("++x = " + ++x);
		System.out.println("x++ = " + x++);
		System.out.println("x = " + x);
		x--; // --x
		System.out.println("x = " + x);
		//
		x += 2;
		System.out.println("x = " + x);
		x -= 3;
		System.out.println("x = " + x);
		x *= 2;
		System.out.println("x = " + x);
		x /= 2; // %=
		System.out.println("x = " + x);
	}
	
	
	
	

}
