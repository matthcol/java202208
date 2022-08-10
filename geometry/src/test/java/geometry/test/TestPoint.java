package geometry.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import geometry.Point;

class TestPoint {

	@Test
	void testCreerDefaut() {
		// create 2 instances (2 objects) of class Point
		Point ptA = new Point();
		Point ptB = new Point();
		System.out.println(ptA);
		System.out.println(ptB);
		System.out.println(ptA.getClass());
		System.out.println(ptA.toString());
		System.out.println(ptA.getName() 
				+ ": " + ptA.getX()
				+ ","  + ptA.getY());
		ptA.setX(3.2);
		System.out.println(ptA.getName() 
				+ ": " + ptA.getX()
				+ ","  + ptA.getY());
		
	}
	
	@Test
	void testCreerComplet() {
		var ptA = new Point("A", 1.2, 3.4);
		System.out.println(ptA);
		System.out.println(ptA.getName() 
				+ ": " + ptA.getX()
				+ ","  + ptA.getY());
	}
	
	@Test
	void testDistance() {
		var ptA = new Point("A", 1.25, 3.5);
		var ptB = new Point("B", 4.25, 7.5);
		var d = ptA.distance(ptB);
		assertEquals(5.0, d);
	}
	
	@Test
	void testTranslate() {
		var ptA = new Point("A", 1.25, 3.5);
		ptA.translate(2.25, -1.25);
		assertAll(
			() -> assertEquals(3.5, ptA.getX(), "x"),
			() -> assertEquals(2.25, ptA.getY(), "y")
		);
	}

	
	
	
	
}
