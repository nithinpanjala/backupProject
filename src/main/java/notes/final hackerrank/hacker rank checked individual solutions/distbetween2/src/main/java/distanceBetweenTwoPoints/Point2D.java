package distanceBetweenTwoPoints;

public class Point2D {
	double x;
	double y;

	Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double dist2D(Point2D value) {
		double xValue = (value.x - x) * (value.x - x);
		double yValue = (value.y - y) * (value.y - y);
		double result = xValue + yValue;
		return Math.sqrt(result);
	}

	public void printDistance(double twoDdistance) {
		System.out.println("2D distance = " + (int) Math.ceil(twoDdistance));
	}

}
