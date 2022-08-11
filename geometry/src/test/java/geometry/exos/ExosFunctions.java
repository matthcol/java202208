package geometry.exos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BiFunction;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import geometry.Point;

class ExosFunctions {

	@Test
	void exoFindFunctionType() {
		// declare adequate types (instead of var)
		
		// var f1 = Point::new;
		// call function and print result
		
		// var f2 = Point::getX;
		// call function and print result
		
		// var f3 = (double d1, double d2) -> (d1+1) / d2;
		// call function and print result
		
		// var f4 = (Point pt, double d) -> pt.setX(d);
		// call function and print point
		
		// var f5 = Point::setName;
		// call function and print point
	}
	
	@Test
	void exoFindAdequateFunction() {
		var ptA = new Point("A", 3, 4);
		var ptB = new Point("B", -3, 4);
		
		// find adequate function
		BiFunction<Double, Double, Point> funPointOfCoords = null;
		Point pt = funPointOfCoords.apply(3.0, 4.0);
		assertEquals(3.0, pt.getX());
		assertEquals(4.0, pt.getY());
		System.out.println(pt);
		
		// find adequate function
		Predicate<Point> isPositiveX = null;
		assertTrue(isPositiveX.test(ptA));
		assertFalse(isPositiveX.test(ptB));
	}

}
