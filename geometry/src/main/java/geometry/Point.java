package geometry;

import java.util.Comparator;

public class Point extends Form implements Comparable<Point>{

	public static Comparator<Point> DEFAULT_COMPARATOR = 
			Comparator.comparing(Point::getX)
				.thenComparing(Point::getY)
				.thenComparing(Form::getName,
						String::compareToIgnoreCase);
	
	// attributes/fields

	private double x;
	private double y;
	
	public Point() {
		super(); // called by defaultz
		// this("", 0.0, 0.0);
	}
	
	public Point(String name, double x, double y) {
		super(name);
		this.x = x;
		this.y = y;
	}
	

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		// TODO: utiliser un StringBuilder si trop de concaténation
		return getName() + "(" + x + "," + y + ")";
	}
	
	// distance
	public double distance(Point other) {
		return Math.hypot(other.x -this.x,other.y-this.y);
	}
	
	// translate
	@Override
	public void translate(double deltaX, double deltaY) {
		this.x += deltaX;
		this.y += deltaY;
	}

	/**
	 * @return value < 0 (means this < other), 
	 * =0 (means this = other,
	 * >0 (means this > other)
	 */
	@Override
	public int compareTo(Point other) {
		return DEFAULT_COMPARATOR.compare(this, other);
	}
	
}
