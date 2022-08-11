package geometry;

public class Circle {
	
	// association with class Point
	// obligatoire
	private Point center;
	
	// > 0, not nan
	private double radius;

	/**
	 * for frameworks as JPA, JSON/XML serializer
	 * NB: possible to not verif all constraints here
	 */
	public Circle() {
		super();
	}

	public Circle(Point center, double radius) {
		super();
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
		return "Circle[c:"
				+ center.getName() 
				+ "; r:" 
				+  radius
				+ "]";
	}

	/**
	 * compute perimeter of this circle : 2.PI.R
	 * @return surface
	 */
	public double perimeter() {
		return 2*Math.PI*radius;
	}

	/**
	 * compute surface of this circle: PI.R² 
	 * @return surface
	 */
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
