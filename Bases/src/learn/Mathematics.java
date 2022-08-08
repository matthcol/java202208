package learn;

public class Mathematics {

	// methode de classe : static
	public static double vitesse(double distance, double temps) {
		double res = distance / temps;
		return res;	
	}

	public static double distance(double x1, double y1, double x2, double y2) {
		// √((x2-x1)²+(y2-y1)²)
		// Sol1: problem with very big or very small exponent
		//		return Math.sqrt(
		//				Math.pow(x2 - x1, 2)
		//				+ Math.pow(y2 - y1, 2));
		// Sol2: deal with very big or very small exponent 
		return Math.hypot(x2 - x1, y2 - y1);
	}
}
