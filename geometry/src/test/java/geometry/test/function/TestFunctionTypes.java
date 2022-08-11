package geometry.test.function;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import geometry.Point;

class TestFunctionTypes {
	
	static Stream<Function<Double, Double>> supplierFunction() {
		return Stream.of(
				Math::sqrt,
				Math::cos,
				x -> Math.pow(x, 2) + 1 // lambda/anonymous function
			);
	}

	@ParameterizedTest
	@MethodSource("supplierFunction")
	void testFunction(Function<Double, Double> f) { 
		var res = f.apply(3.0);
		System.out.println(res);
	}

	// same thing in primitive mode (optimized)
	
	static Stream<DoubleUnaryOperator> supplierFunctionOpt() {
		return Stream.of(
				Math::sqrt,
				Math::cos,
				x -> Math.pow(x, 2) + 1 // lambda/anonymous function
			);
	}

	@ParameterizedTest
	@MethodSource("supplierFunctionOpt")
	void testDoubleUnaryOperator(DoubleUnaryOperator f) { 
		var res = f.applyAsDouble(3);
		System.out.println(res);
	}

	
	@Test
	void testBiFunction() {
		var ptA = new Point("A", 1, 2);
		var ptB = new Point("B", 5, -1);
		BiFunction<Double, Double, Double> f1 = Math::pow;
		System.out.println(f1.apply(2.0,10.0));
		BinaryOperator<Double> op = Math::pow;
		System.out.println(op.apply(2.0,10.0));
		DoubleBinaryOperator op2 = Math::pow;
		System.out.println(op2.applyAsDouble(2, 10));
		
		BiFunction<Point, Point, Double> f2 = Point::distance;
		System.out.println(f2.apply(ptA, ptB));
		f2 = (p1, p2) -> p1.distance(p2);
		System.out.println(f2.apply(ptA, ptB));
	}

}
