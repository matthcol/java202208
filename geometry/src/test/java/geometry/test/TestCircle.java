package geometry.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import geometry.Circle;
import geometry.Point;

class TestCircle {

	@Test
	void testCreateCircle() {
		var ptA = new Point("A", 3, 4);
		var circle1 = new Circle("C", ptA, 5);
		System.out.println(circle1);
	}
	
	@Test
	void testPerimeter() {
		var ptA = new Point("A", 3, 4);
		var circle1 = new Circle("C", ptA, 5);
		double actualPerimeter = circle1.perimeter();
		double expectedPerimeter = 31.41592653589793;
		assertEquals(expectedPerimeter, actualPerimeter, 1E-9);
	}
	
	@Test
	void testSurface() {
		var ptA = new Point("A", 3, 4);
		var circle1 = new Circle("C", ptA, 5);
		double actualSurface = circle1.surface();
		double expectedSurface = 78.53981633974483;
		assertEquals(expectedSurface, actualSurface, 1E-9);
	}
	
	@Test
	void testContainsTrue() {
		var ptA = new Point("A", 3, 4);
		var circle1 = new Circle("C", ptA, 5);
		var ptB = new Point("B", 5, 6);
		boolean ok = circle1.contains(ptB);
		assertTrue(ok);
	}
	
	@Test
	void testContainsFalse() {
		var ptA = new Point("A", 3, 4);
		var circle1 = new Circle("C", ptA, 5);
		var ptB = new Point("B", 7, 8);
		boolean ok = circle1.contains(ptB);
		assertFalse(ok);
	}

}
