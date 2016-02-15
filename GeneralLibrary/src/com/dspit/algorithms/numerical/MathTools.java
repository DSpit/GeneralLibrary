package com.dspit.algorithms.numerical;

/**
 * Class designed to be a utility for common mathematical operations
 * on numbers.
 * 
 * @author David Boivin ~AbSynth
 *
 */
public class MathTools {

	/**
	 * This algorithm calculates the greatest common divisor between the two
	 * Parameters. This method uses the age old Euclidian algorithm which is one
	 * of the fastest and most elegant ways of finding the GDC.
	 * <br><b> Note:</b> if the result of this algorithm is 1, then the numbers a
	 * and b are coprime or relatively prime.
	 * 
	 * @param a	First number to use to find the GDC.
	 * @param b Second number to use to find the GDC.
	 * @return The Greatest Common Divisor (GDC) of parameters a and b.
	 */
	public static int GDC(int a, int b){
		while(b != 0){
			int r = a % b;	//find the remainder of the two numbers 
			//using matimatical fact proven by Euclid that GDC(A, B) = GDB(B, r)
			a = b;
			b = r;
		}
		
		return a;
	}
	
}
