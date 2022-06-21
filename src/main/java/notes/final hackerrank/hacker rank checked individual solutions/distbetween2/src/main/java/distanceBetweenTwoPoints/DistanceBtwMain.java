package distanceBetweenTwoPoints;

import java.util.Scanner;

public class DistanceBtwMain {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int x1 = scanner.nextInt();
		int y1 = scanner.nextInt();
		int z1 = scanner.nextInt();
		int x2 = scanner.nextInt();
		int y2 = scanner.nextInt();
		int z2 = scanner.nextInt();
		scanner.close();
		
		Point3D p1 = new Point3D(x1, y1, z1);
		Point3D p2 = new Point3D(x2, y2, z2);
		double distance2D = p1.dist2D(p2);
		double distance3D = p1.dist3D(p2);
		
		Point2D p = new Point2D(0, 0);
		p.printDistance(distance2D);
		p=p1;
		p.printDistance(distance3D);
		

	}

}
