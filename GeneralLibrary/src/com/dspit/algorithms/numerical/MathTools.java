package com.dspit.algorithms.numerical;

import java.util.Arrays;
import java.util.LinkedList;

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
	public static int gdc(int a, int b){
		while(b != 0){
			int r = a % b;	//find the remainder of the two numbers 
			//using matimatical fact proven by Euclid that GDC(A, B) = GDB(B, r)
			a = b;
			b = r;
		}
		
		return a;
	}
	
	public static float exp(float x, int p){
		float r = 1;
		while(p >= 1){
			r *= x;
			p--;
		}
		return r;
	}
	//http://martin.ankerl.com/2007/10/04/optimized-pow-approximation-for-java-and-c-c/
	public static float fastExp(float x, int p){
		float r = 1;
		String binary;
		float[] powers = new float[1+(int)(Math.log(p)/Math.log(2))];
		powers[0] = x;
		for(int i = 1; i < powers.length; i++){
			powers[i] = powers[i-1] * powers[i-1]; 
		}
		
		binary = Integer.toBinaryString(p);
		for(int i = 0; i < binary.length()-1; i++){
			if(binary.charAt(i) == '1'){
				r *= powers[binary.length()-1-i];
			}
		}
		
		return r;
	}
}
