package geometry.exos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntToDoubleFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;

import org.junit.jupiter.api.Test;

import geometry.Point;
import geometry.function.PointSupplierWithArgs;
import geometry.function.TriFunction;

class ExosFunctions {

	@Test
	void exoFindFunctionType() {
		var ptA = new Point("A", 3, 4);
		// declare adequate types (instead of var)
		
		Supplier<Point> f1 = Point::new; //constructor by default
		// call function and print result
		Point point1 = f1.get();
		System.out.println("Result f1: " + point1);
		
		PointSupplierWithArgs f1bis = Point::new; //constructor with 3 args
		// call function and print result
		Point point1bis = f1bis.get("B", 4, 5.0);
		System.out.println("Result f1bis: " + point1bis);
		
		TriFunction<String, Double, Double, Point> f1ter = 
				Point::new; //constructor with 3 args
		// call function and print result
		Point point1ter = f1ter.apply("B", 4.0, 5.0);
		System.out.println("Result f1ter: " + point1ter);
		
		
		ToDoubleFunction<Point> f2 = Point::getX;
		// call function and print result
		double x = f2.applyAsDouble(ptA);
		System.out.println("Result f2: " + x);
		
		DoubleBinaryOperator f3 = 
				(double d1, double d2) -> (d1+1) / d2;
		// call function and print result
		double res = f3.applyAsDouble(3.0, 4.4);
		System.out.println("Result f3: " + res);
		
		ObjDoubleConsumer<Point> f4 = 
				(Point pt, double d) -> pt.setX(d);
		// call function and print point
		f4.accept(ptA, 10.25);
		System.out.println("After calling f4: " + ptA);
		
		BiConsumer<Point, String> f5 = Point::setName; 
		// Point::setName i.e. (Point p, String n) -> p.setName(n)
		// call function and print point
		f5.accept(ptA, "A'");
		System.out.println("After calling f5: " + ptA);
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
