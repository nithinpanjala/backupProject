package com.distancebetweentwopoints;

import java.util.Scanner;

class Point3D extends Point2D {
	Double z;
	
	public Point3D(Double x, Double y, Double z) {
		super(x, y);
		this.z = z;
	}

	public Double dist3D(Point3D p) {
		//Double d1 = (p.x-x)*(p.x-x);
		//Double d2 = (p.y-y)*(p.y-y);
		//Double d3 = (p.z-z)*(p.z-z);
		
		Double d1 = Math.pow((p.x-x), 2);
		Double d2 = Math.pow((p.y-y), 2);
		Double d3 = Math.pow((p.z-z), 2);
		
		return Math.sqrt(d1+d2+d3);
	}
	
	public static void printDistance(Double d) {
		System.out.println("3D distance = " + (int) Math.ceil(d));
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter point p1 coordinates");
		Double x1 = scanner.nextDouble();
		Double y1 = scanner.nextDouble();
		Double z1 = scanner.nextDouble();
		
		Point3D p1 = new Point3D(x1, y1, z1);
		
		System.out.println("Enter point p2 coordinates");
		Double x2 = scanner.nextDouble();
		Double y2 = scanner.nextDouble();
		Double z2 = scanner.nextDouble();
		scanner.close();
		Point3D p2 = new Point3D(x2, y2, z2);
		
		Double dist_2d = p1.dist2D(p2);
		Double dist_3d = p1.dist3D(p2);
		
		Point2D.printDistance(dist_2d);
		Point3D.printDistance(dist_3d);
		
	}
}
