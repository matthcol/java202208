package geometry;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class Circle extends Form implements Mesurable2D {
	
	// association with class Point
	// obligatoire
	@NotNull
	private Point center;
	
	// > 0, not nan
	@Positive
	private double radius;

	/**
	 * for frameworks as JPA, JSON/XML serializer
	 * NB: possible to not verif all constraints here
	 */
	public Circle() {
		super();
	}


	public Circle(String name, Point center, double radius) {
		super(name);
		this.center = center;
		this.radius = radius;
	}



	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public String toString() {
		return "Circle[n:"
				+getName()
				+ "; c:"
				+ center.getName() 
				+ "; r:" 
				+  radius
				+ "]";
	}

	@Override
	public void translate(double deltaX, double deltaY) {
		// TODO
	}

	/**
	 * compute perimeter of this circle : 2.PI.R
	 * @return surface
	 */
	@Override
	public double perimeter() {
		return 2*Math.PI*radius;
	}

	/**
	 * compute surface of this circle: PI.R² 
	 * @return surface
	 */
	@Override
	public double surface() {
		return Math.PI*radius*radius;
		// return Math.PI*Math.pow(radius,2);
	}

	/**
	 * test if point is inside this circle
	 * formula: distance(center, point) < radius
	 * @param point to inspect
	 * @return true is point inside, else false 
	 */
	public boolean contains(Point point) {
		return center.distance(point)  < radius;
	}
	
	

}
