/**
 * Driver class to test Triangle class.
 *
 * Written by Roshan Sen on 11/26
 **/

import java.util.Scanner;
import java.lang.Exception;

public class Driver {
	
	/**
	 * Method to collect triangle side data inputted by user.
	 **/
	public static double[] userInput(){
		double[] sides = new double[3];
		System.out.println("Please enter the length of the sides of your triangle.");
		int currentSide = 1;
		while(currentSide <= 3) {
			try{
				Scanner scan = new Scanner(System.in);
				System.out.print("Side " + currentSide + ": ");
				sides[currentSide - 1] = scan.nextDouble();
				currentSide++;
			}
			catch(Exception e){
				System.out.println("Invalid Input, please try again.");
				System.out.println();
			}
		}
		return sides;
	}
	 
	//Main Method
	public static void main(String[] args){
		boolean validTriangle = false;
		double[] triangleSides = new double[3];
		Triangle t;
		while(!validTriangle){
			triangleSides = userInput();
			
			try {
				t = new Triangle(triangleSides[0], triangleSides[1], triangleSides[2]);
				validTriangle = true;
			}
			catch(IllegalTriangleException i){
				System.out.println("The triangle dimensions were invalid, please try again.");
			}
			catch(Exception e){
				System.out.println("Something went wrong.");
			}
		}
	}
}