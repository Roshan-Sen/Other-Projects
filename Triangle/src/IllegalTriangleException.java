/**
 * Exception class to handle triangles that violate geometry
 * rules.
 *
 * Written by Roshan Sen 11/26
 */

import java.lang.Exception;

 public class IllegalTriangleException extends Exception {
	/**
	 * Constructor for the IllegalTriangleException class.
	 */
	public IllegalTriangleException(String message){
		super(message);
	}
 }