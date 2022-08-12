package geometry.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import geometry.Point;
import geometry.WeightedPoint;

class TestWeightedPoint {

	@Test
	void testConstructorWithArgs() {
		var wp = new WeightedPoint("A", 3.25, 4.5, 2.5);
		System.out.println(wp);
		assertAll(
				() -> assertEquals("A", wp.getName()),
				() -> assertEquals(3.25, wp.getX()),
				() -> assertEquals(4.5, wp.getY()),
				() -> assertEquals(2.5, wp.getWeight()));
	}
	
	@Test
	void testWeightedPointSubstituteForPoint() {
		WeightedPoint wp = new WeightedPoint("A", 3.25, 4.5, 2.5);
		assertTrue(wp instanceof WeightedPoint);
		assertTrue(wp instanceof Point);
		assertTrue(wp instanceof Object);
		
		// 1. substitution with a variable
		Point p = wp;
		System.out.println(p.getName());
		System.out.println(p.getX() + "/" + p.getY());
		// p.getWeight(); //method not visible as a point
		
		// 2. substitution with a function argument
		Point ptB = new Point("B", 4, 5);
		double d = ptB.distance(wp); // by lsp
		System.out.println("distance Pt -> WP: " + d);
		d = wp.distance(ptB); // by inheritance
		System.out.println("distance WP -> Pt: " + d);
		
		// 3. substitution with a collection
		List<Point> points = List.of(
				wp,
				ptB,
				new WeightedPoint("C", 5.5, 6.6, 7.7),
				new Point("D", 6.6, 7.7)
			);
		System.out.println(points);
		double xSum = points.stream()
			.mapToDouble(Point::getX)
			.sum();
		System.out.println(xSum);		
	}
	
	@Test
	void testDowncasting() {
		List<Point> points = List.of(
				new WeightedPoint("A", 1.5, 6.6, 7.7),
				new Point("B", 2.6, 7.7),
				new WeightedPoint("C", 5.5, 6.6, -4.7),
				new Point("D", 6.6, 7.7)
			);
		//comment retrouver les WP au milieu des Points
		for (Point pt: points) {
			// Java 1/8/11	
			if (pt instanceof WeightedPoint) {
				//double weight = ((WeightedPoint) pt).getWeight();
				WeightedPoint wp = (WeightedPoint) pt;
				double weight = wp.getWeight();
				System.out.println("WP: " + wp + " -> weight: " + weight);
			}
		}
	}
	
	@Test
	void testDowncastingJ17() {
		List<Point> points = List.of(
				new WeightedPoint("A", 1.5, 6.6, 7.7),
				new Point("B", 2.6, 7.7),
				new WeightedPoint("C", 5.5, 6.6, -4.7),
				new Point("D", 6.6, 7.7)
			);
		//comment retrouver les WP au milieu des Points
		for (Point pt: points) {
			// Java 17
			switch(pt) {
				case WeightedPoint wp:
					double weight = wp.getWeight();
					System.out.println("WP: " + wp + " -> weight: " + weight);
					break;
				default:
					System.out.println("Point " + pt + " is not a WP" );
			}
		}
	}


	
}
