

package com.dspit.algorithms.numerical;

import java.util.Arrays;

/**
 * Library of general randomization algorithms. All methods are static and
 * so this class is to be used as a tool, rather than an object.
 * 
 * @author David Boivin (Spit)
 */
public final class Random {

	/**
	 * Generates a sequence of pseudo-random numbers based on the linearly 
	 * adding all the constants with the previous value in the sequence,
	 * starting with the seed.
	 * <br><br>
	 * <b>X[0] = seed <br>X[n+1] = (A * X[n] + B) % M</b>
	 * <br><br>
	 * This pseudo-random number generator (PRNG) is pretty simple and therefore
	 * also pretty predictable, though it has the feature of being able to 
	 * reproduce a sequence. Useful for testing and repeated queries which need 
	 * to find a given input. This algorithm also comes with the feature of being
	 * able to cap its the randomly generated numbers using the formula cap = mod - 1.<br><br>
	 * The pitfalls of this algorithm is that after a given point the sequence is
	 * bound to repeat. This is the nature of the modulo function. This also means
	 * that not all the values between 0 and modulo will be generated before the
	 * sequence repeats.
	 * 
	 * @param sequenceLength Length of sequence to produce.
	 * @param seed	The starting value from which to begin the pseudo-random sequence.
	 * @param cMulti Constant multiple.
	 * @param cAdd Constant addition.
	 * @param mod The max value of that can be generated. Value is used to modulo
	 * 			the whole sequence.
	 * 
	 * @return A sequence of pseudo-random values which are generated from the
	 * 				parameters.
	 */
	public static int[] linearCongruentialGenerator(int sequenceLength, int seed, int cMulti, int cAdd, int mod){
		//initializations
		int[] rSequence = new int[sequenceLength];
		
		//fill output sequence with pseudo-random sequence
		rSequence[0] = Math.abs(cMulti*seed+cAdd) % mod;
		for(int i = 1; i < sequenceLength; ++i){
			rSequence[i] = Math.abs(cMulti*rSequence[i-1]+ cAdd) % mod;
		}
		
		return rSequence; 
	}
	
	/**
	 * This method makes use of the {@link #linearCongruentialGenerator(int, int, int, int, int)} to generate a list 
	 * of values which are then processed by the formula :<br><br>
	 * 
	 * <b>result = min + (sequence# / mod) * (max-min)</b><br><br>
	 * 
	 * which is a formula that ensures that the result is still as fair as the generated number. 
	 * <br><br><b>NOTE:</b> That the min and max are included in the range
	 * 
	 * @param minValue The minimum value that this algorithm should generate (included)
	 * @param maxValue The maximum value that this algorithm should generate (included)
	 * @param sequenceLength used in {@link #linearCongruentialGenerator()}
	 * @param seed used in {@link #linearCongruentialGenerator()}
	 * @param cMulti used in {@link #linearCongruentialGenerator()}
	 * @param cAdd used in {@link #linearCongruentialGenerator()}
	 * @param mod used in {@link #linearCongruentialGenerator()}
	 * 
	 * @return A sequence of pseudo-random values which are generated from the
	 * 				parameters. These values are pseudo-randomly chosen from within
	 * 				the range of the minimum value and maximum value parameters.
	 */
	public static int[] linearCongruentialGenerator(int sequenceLength, int seed, int cMulti, int cAdd, int mod, int minValue, int maxValue){
		//generate a sequence of random numbers between 0 and mod.
		int[] rSequence = Random.linearCongruentialGenerator(sequenceLength, seed, cMulti, cAdd, mod);
		
		//using the generated values, and making sure to keep the result mathematically fair, make the result
		//of each value generate a ratio between 0 and 1. This will make sure that the multiplication of the
		//range will result in a number which is within that range and can be added to the minimum value. Note that
		//the randomness of this algorithm is entirely dependent on the randomness of the sequence generator,
		//in this case, a Linear Congruential Generator.
		for(int i = 0; i < sequenceLength; ++i){
			rSequence[i] = minValue + Math.round((float)rSequence[i]/(float)(mod)*(maxValue-minValue));
		}
		
		return rSequence;
	}
	
	public static int[] multiLinearCongeuntialGenerator(int sequenceLength, int seed, int cMultiInit, int cAddInit){ //TODO multiple random number generator
		return null;
	}
	
	/**
	 * This method uses the {@link #linearCongruentialGenerator(int, int, int, int, int, int, int)}
	 * method from this class to randomize the input array. It will generate a random number within 
	 * the bounds of the input array using the number stored in the current location being randomized 
	 * within the array as a seed. This gives the algorithm the feature of being able to reproduce the
	 * "randomized" array given you feed the algorithm the exact same input array. 
	 * <br><br>Runs in O(N) time, but it is important to note that through running the algorithm 
	 * multiple times will move the items around more, this does  not mean that the array is any 
	 * more random, mathematically speaking.
	 * 
	 * <br><br><b>NOTE:</b> This method will alter the original array. 
	 * 
	 * @param array The array to randomize.
	 */
	public static void randomizeArray(int[] array){
		int add = 17, multi = 11;	//arbitrary (i selected 2 primes)
		int mod = 100;	//modded 100 because the mod will be turned into a percentage anyway
		
		//loop through the array
		int j = 0, temp = 0;
		for(int i = 0; i < array.length; ++i){
			//randomly generate a new index in the array
			j = Random.linearCongruentialGenerator(1, array[i], multi, add, mod, 0, array.length)[0];
			
			//swap original value with the randomly selected new index's value.
			temp = array[j];
			array[j] = array[i];
			array[i] = temp;
		}
	}
	
	
	/** TODO
	 * NOTE: will produce the same sequence of numbers given the same array.
	 * @param array
	 * @param selections
	 * @return
	 */
	public static int[] randomlySelect(int[] array, int selections){
		//create a copy of the array so as to not modify the original
		//in the processing to find the selections.
		int[] temp = Arrays.copyOf(array, array.length);
		
		//randomize the array so as to select at "randomly" as many elements 
		//as the parameter dictates to output as the selected elements
		Random.randomizeArray(temp);
		return Arrays.copyOf(temp, selections);
	}
	
}
