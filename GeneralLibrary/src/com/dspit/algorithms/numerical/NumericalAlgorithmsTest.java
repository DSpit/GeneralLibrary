

package com.dspit.algorithms.numerical;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Class used to test all numerical algorithms in this package. Used both for 
 * examining and understanding the algorithms as well as to make them better
 * and more efficient.
 * 
 * @author David Boivin (Spit)
 *
 */
public final class NumericalAlgorithmsTest {
	
	public static void main(String[] args){
		NumericalAlgorithmsTest test = new NumericalAlgorithmsTest();
		
		test.randomLinearCongruentialGenerator(50, 35, 409, 234, 100);
		test.randomLinearCongruentialGenerator(50, 0, 409, 234, 100);
		test.randomLinearCongruentialGenerator(50, 3, 409, 234, 100);
	}
	
	public static void randomLinearCongruentialGenerator(int testSequenceLength, int testSeed, int testCMulti, int testCAdd, int testMod){
		
		//introduce
		System.out.println("Linear Congruential Generator Test for Random Numbers:");
		
		//initialized all variables for more efficient testing and accurate elapsed time calculations
		int[] output;
		long startTime;
		long elapsedTime;
		
		//start test
		System.out.println("Sequence Length: " + testSequenceLength + "\n" +
							"Seed: " + testSeed+ "\nBegin Generating...");
		startTime = System.nanoTime();
		output = Random.linearCongruentialGenerator(testSequenceLength, testSeed, testCMulti, testCAdd, testMod);
		elapsedTime = System.nanoTime() - startTime;
		System.out.println("...End\n" + 
							"Total Time Taken: " + elapsedTime + "ns ("
							+ TimeUnit.MICROSECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS) + "micros)");
		
		//read out output and test
		System.out.println("Output: " + Arrays.toString(output));
		
		//length test
		System.out.println("Length Test: " + output.length + " == " + 
							testSequenceLength + " = " + 
				(output.length == testSequenceLength));
		
		//repetition test TODO later
//		int[] repeatSequence = new int[testSequenceLength];
//		repeatSequence[0] = output[0];
//		int repeatSequenceLength = 1;
//		int repeatSequenceCount = 0;
//		for(int i = 1; i < testSequenceLength; ++i){
//			if(repeatSequenceCount > 0 && repeatSequence[repeatSequenceCount] != output[i]){
//				for(int k = 0; k < repeatSequenceCount; ++k){
//					repeatSequence[repeatSequenceLength] = repeatSequence[k];
//					repeatSequenceLength++;
//				}
//				repeatSequenceCount = 0;
//			}else if(repeatSequence[repeatSequenceCount] == output[i]){
//				repeatSequenceCount++;
//				continue;
//			} 
//			
//			repeatSequence[repeatSequenceLength] = output[i];
//			repeatSequenceLength++;
//		}
//		
//		System.out.println("Repeat Sequence: " + Arrays.toString(repeatSequence));
//		System.out.println("Repeat Ratio: " + repeatSequence.length + " : " + output.length);
		
		System.out.println();
	}
	
}