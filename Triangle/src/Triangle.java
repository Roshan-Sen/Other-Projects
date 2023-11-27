/**
 * This is a class that represents a triangle.
 * The sum of two sides of the triangle created should be greater
 * than the other side. If that does not occur, an
 * exception is thrown.
 *
 * Written by Roshan Sen on 11/26
 **/

import java.lang.Math;

public class Triangle {
	private double sideOneLength;
	private double sideTwoLength;
	private double sideThreeLength;
	
	/**
	 * Constructor for Triangle objects
	 */
	public Triangle(double side1, double side2, double side3) throws IllegalTriangleException{
		if(validTriangle(side1, side2, side3)) {
			sideOneLength = side1;
			sideTwoLength = side2;
			sideThreeLength = side3;
			this.perimeterAndArea();
		}
		else {
			System.out.println("The triangle dimensions are invalid.");
			System.out.println();
			throw new IllegalTriangleException("Triangle dimensions invalid");
		}
	}
	
	/**
	 * Method to validate if the sides can produce a triangle.
	 */
	private boolean validTriangle(double s1, double s2, double s3){
		if(((s1 + s2) > s3) && ((s1 + s3) > s2) && ((s2 + s3) > s1)){
			return true;
		}
		return false;
	}
	
	/**
	 * Method to display the triangles perimeter and area.
	 */
	private void perimeterAndArea(){
		double perimeter = sideOneLength + sideTwoLength + sideThreeLength;
		String perimeterString = String.format("%.2f", perimeter);
		System.out.println("The perimeter of this triangle is " + perimeterString + " units.");
		double semip = perimeter / 2;
		double area = Math.sqrt(semip * (semip - sideOneLength) * (semip - sideTwoLength) * (semip - sideThreeLength));
		String areaString = String.format("%.2f", area);
		System.out.println("The area of this triangle is " + areaString + " units squared.");
	}
}