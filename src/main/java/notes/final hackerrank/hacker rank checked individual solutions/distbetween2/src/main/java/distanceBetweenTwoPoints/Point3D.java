package distanceBetweenTwoPoints;

public class Point3D extends Point2D {
	double z;

	Point3D(double x, double y, double z) {
		super(x, y);
		this.z = z; 
	}

	public double dist3D(Point3D value) {
		double xValue = (value.x - x) * (value.x - x);
		double yValue = (value.y - y) * (value.y - y);
		double zValue = (value.z - z) * (value.z - z);
		double sum = xValue + yValue + zValue;
		return Math.sqrt(sum);
	}

	public void printDistance(double threeDdist) {
		System.out.println("3D distance = " + (int) Math.ceil(threeDdist));
	}

}
