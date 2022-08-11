package geometry;

public class WeightedPoint extends Point {
	
	private double weight;

	public WeightedPoint() {
		// super();
	}
	
	public WeightedPoint(String name, double x, double y, double weight) {
		super(name, x, y);
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return super.toString() + "#" + weight;
	}

}
