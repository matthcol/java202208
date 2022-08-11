package geometry.function;

import geometry.Point;

@FunctionalInterface
public interface PointSupplierWithArgs {
	
	Point get(String name, double x, double y);
}
