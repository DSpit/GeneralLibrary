

package com.dspit.algorithms.numerical;

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
	 * able to cap its the randomly generated numbers.<br><br>
	 * The pitfalls of this algorithm is that after a given point the sequence is
	 * bound to repeat. This is the nature of the modulo function. This also means
	 * that not all the values between 0 and modulo will be generated before the
	 * sequence repeats.
	 * 
	 * @param sequenceLength Length of sequence to produce.
	 * @param seed	The starting value from which to begin the pseudo-random sequence.
	 * @param cMulti Constant multiple.
	 * @param cAdd Constant addition.
	 * @param maxValue The max value of that can be generated. Value is used to modulo
	 * 			the whole sequence.
	 * 
	 * @return A sequence of pseudo-random values which are generated from the
	 * 				parameters.
	 */
	public static int[] linearCongruentialGenerator(int sequenceLength, int seed, int cMulti, int cAdd, int maxValue){
		//initializations
		int[] rSequence = new int[sequenceLength];
		
		//fill output sequence with pseudo-random sequence
		rSequence[0] = (cMulti*seed+cAdd) % maxValue;
		for(int i = 1; i < sequenceLength; ++i){
			rSequence[i] = (cMulti*rSequence[i-1]+ cAdd) % maxValue;
		}
		
		return rSequence; 
	}
	
	public static int[] multiLinearCongeuntialGenerator(int sequenceLength, int seed, int cMultiInit, int cAddInit){ //TODO multiple random number generator
		return null;
	}
}