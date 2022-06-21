package com.distancebetweentwopoints;

class Point2D {
	Double x;
	Double y;
	
	
	public Point2D(Double x, Double y) {
		super();
		this.x = x;
		this.y = y;
	}


	public Double  dist2D(Point2D p) {
		//Double d1 = (p.x-x)*(p.x-x);
		//Double d2 = (p.y-y)*(p.y-y);
		
		Double d1 = Math.pow((p.x-x), 2);
		Double d2 = Math.pow((p.y-y), 2);
		
		return Math.sqrt(d1+d2);
	}
	
	public static void printDistance(Double d) {
		System.out.println("2D distance = " + (int) Math.ceil(d));
	}
}
