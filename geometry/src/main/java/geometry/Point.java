package geometry;

public class Point {

	// attributes/fields
	private String name;
	private double x;
	private double y;
	
	public Point() {
	}
	
	public Point(String name, double x, double y) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	public String getName() {
		return name;
		// i.e.:
		// return this.name;
	}
	public void setName(String name) {
		this.name = name;
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
		return name + "(" + x + "," + y + ")";
	}
	
	// distance
	public double distance(Point other) {
		return Math.hypot(other.x -this.x,other.y-this.y);
	}
	
	// translate
	public void translate(double deltaX, double deltaY) {
		this.x += deltaX;
		this.y += deltaY;
	}
	
}
