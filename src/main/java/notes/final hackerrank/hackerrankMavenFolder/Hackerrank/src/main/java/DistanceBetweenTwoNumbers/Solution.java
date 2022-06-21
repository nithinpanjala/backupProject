package DistanceBetweenTwoNumbers;

public class Solution {
	
	/* Write your class implementations here. Do not use access modifiers when
	declaring your classes. */
	class Point2D {
	 double x;
	 double y;
	 
	 Point2D (double x, double y) {
	 this.x=x;
	 this.y=y;
	 }
	 
	 public double dist2D(Point2D value){
	 	double xValue = (value.x-x)*(value.x-x);
	 	double yValue = (value.y-y)*(value.y-y);
	 	double result = xValue+yValue;
	 	return Math.sqrt(result);
	   }
	 
	 public void printDistance(double value){
	 	System.out.println("2D distance = "+(int)Math.ceil(value));
	 }
	 
	}

	class Point3D extends Point2D {
	 double z;
	 
	 Point3D(double x, double y, double z){
	 super(x,y);
	 this.z=z;
	 }
	 
	  public double dist3D(Point3D value){
	 	double xValue = (value.x-x)*(value.x-x);
	 	double yValue = (value.y-y)*(value.y-y);
	 	double zValue = (value.z-z)*(value.z-z);
		double sum = xValue+yValue+zValue;
	 	return Math.sqrt(sum);
	 }
	 
	 public void printDistance(double value){
	 	System.out.println("3D distance = "+(int)Math.ceil(value));
	 }
	 
	}
	
	

}
