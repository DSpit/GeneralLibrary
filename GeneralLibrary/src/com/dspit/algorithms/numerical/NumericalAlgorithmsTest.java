

package com.dspit.algorithms.numerical;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import com.dspit.algorithms.numerical.MathTools;

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
		
/*		test.randomLinearCongruentialGenerator(50, 35, 409, 234, 100);
		test.randomLinearCongruentialGenerator(50, 0, 409, 234, 100);
		test.randomLinearCongruentialGenerator(50, 3, 409, 234, 100);
		test.randomLinearCongruentialGenerator(50, 3, 409, 235, 2); //NOTE: generates alternating 0 and 1 because all multiplication and addition is being done by odd numbers.
		test.randomLinearCongruentialGenerator(50, 2, 402, 232, 2);	//NOTE: only generates 0 because all multiplication and addition is being done by even numbers.
*/		
/*		for(int i = 0; i < 5; ++i){
			test.randomRangedLinearCongruentialGenerator(100, i, 508, 67, 100, 20, 30);
		}
		
		test.randomLinearCongruentialGenerator(100, 6, 508, 67, 100);
*/
/*		
		test.randomizeArray(new int[]{1,2,3,4,5,6,7,8,9,10});
		int[] testArray = new int[500];
		for(int i = 0; i < testArray.length; ++i){
			testArray[i] = (int)(Math.random()*Integer.MAX_VALUE);
		}
		test.randomizeArray(Arrays.copyOf(testArray, testArray.length));
		test.randomizeArray(testArray);
		test.randomizeArray(testArray);*/
		
/*		test.randomlySelect(new int[]{1,2,3,4,5,6,7,8,9,10}, 3);*/
		
/*		test.getGDC(6, 12);//to remove initialization time error
		test.getGDC(6, 12);
		test.getGDC(982451653, 472882027);*/
		
		test.getFastExp(7, 6);
		test.getFastExp(7, 6);
		test.getFastExp(7, 30);
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
	
	public static void randomRangedLinearCongruentialGenerator(int testSequenceLength, int testSeed, int testCMulti, int testCAdd, int testMod, int minValue, int maxValue){

		//introduce
			System.out.println("Ranged Linear Congruential Generator Test for Random Numbers:");
			
			//initialized all variables for more efficient testing and accurate elapsed time calculations
			int[] output;
			long startTime;
			long elapsedTime;
		
			//start test
			System.out.println("Sequence Length: " + testSequenceLength + "\n" +
									"Seed: " + testSeed+ "\nBegin Generating...");
			startTime = System.nanoTime();
			output = Random.linearCongruentialGenerator(testSequenceLength, testSeed, testCMulti, testCAdd, testMod, minValue, maxValue);
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("...End\n" + 
								"Total Time Taken: " + elapsedTime + "ns ("
								+ TimeUnit.MICROSECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS) + "micros)");
				
			//read out output and test
			System.out.println("Output: " + Arrays.toString(output));
			
			//range check
			System.out.println("Min Value: " + minValue + "\nMax Value: " + maxValue);
			boolean check = true;
			for(int i = 0; i < testSequenceLength; ++i){
				if(output[i] < minValue){
					System.out.print(" ( MIN" +">" + output[i] + ") ");
					check = false;
				}else if(output[i] > maxValue){
					System.out.print(" (" + output[i] + "> MAX ) ");
					check = false;
				}
			}
			System.out.println("Range Check : " + check);
	}
	
	public static void randomizeArray(int[] array){
		//introduce
		System.out.println("Randomizing Array Test for Random Numbers:");
		
		//initialized all variables for more efficient testing and accurate elapsed time calculations
		long startTime;
		long elapsedTime;
		int[] input = Arrays.copyOf(array, array.length);
	
		//start test
		System.out.println("Origional Array: " + Arrays.toString(array) + "\nBegin Generating...");
		startTime = System.nanoTime();
		Random.randomizeArray(array, 17 , 11);
		elapsedTime = System.nanoTime() - startTime;
		System.out.println("...End\n" + 
							"Total Time Taken: " + elapsedTime + "ns ("
							+ TimeUnit.MICROSECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS) + "micros)");
			
		//read out output and test
		System.out.println("Output: " + Arrays.toString(array));
		
		//checks if any of the old values are in the same index
		boolean[] check = new boolean[array.length];
		for(int i = 0; i < array.length; ++i){
			check[i] = !(array[i] == input[i]);
		}
		//read out output and test
		System.out.println("Is Index different: " + Arrays.toString(check));
		
	}
	
	public static void randomlySelect(int[] array, int selections){
		//introduce
		System.out.println("Randomizing Array Test for Random Numbers:");
			
		//initialized all variables for more efficient testing and accurate elapsed time calculations
		long startTime;
		long elapsedTime;
		int[] output;
	
		//start
		System.out.println("Origional Array: " + Arrays.toString(array) + "\nBegin Generating...");
		startTime = System.nanoTime();
		output = Random.randomlySelect(array, selections, 17, 11);
		elapsedTime = System.nanoTime() - startTime;
		System.out.println("...End\n" + 
						"Total Time Taken: " + elapsedTime + "ns ("
							+ TimeUnit.MICROSECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS) + "micros)");
			
		//read out output and test
		System.out.println("Output: " + Arrays.toString(output));
	}
	
	public static void getGDC(int a , int b){
		//introduce
		System.out.println("Finding the GDC test for numbers " + a + " and " + b);
		
		//variables
		long startTime;
		long elapsedTime;
		int output;
		
		//start
		startTime = System.nanoTime();
		output = MathTools.gdc(a,b) ;
		elapsedTime = System.nanoTime() - startTime;
		System.out.println("...End\n" + 
						"Total Time Taken: " + elapsedTime + "ns ("
							+ TimeUnit.MICROSECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS) + "micros)");
			
		//read out output and test
		System.out.println("Output: " + output);
	}
	
	public static void getFastExp(float x, int p){
		//introduce
		System.out.println("Fast Exponential Test:");
		
		//variables
		long startTime;
		long elapsedTime;
		float output;
		float baselineOutput;
		float systemOutput;
		
		//start exponential test
		startTime = System.nanoTime();
		baselineOutput = MathTools.exp(x,p);
		elapsedTime = System.nanoTime() - startTime;
		System.out.println("...End Exponential test\n" + 
						"Total Time Taken: " + elapsedTime + "ns ("
							+ TimeUnit.MICROSECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS) + "micros)");
		
		System.out.println("Baseline: " + baselineOutput);
		
		//start system exponential test
		startTime = System.nanoTime();
		systemOutput = (float)Math.pow(x,p);
		elapsedTime = System.nanoTime() - startTime;
		System.out.println("...End System test\n" + 
						"Total Time Taken: " + elapsedTime + "ns ("
							+ TimeUnit.MICROSECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS) + "micros)");
		
		System.out.println("System: " + systemOutput);
		
		//start fast exponential test
		startTime = System.nanoTime();
		output = MathTools.fastExp(x,p);
		elapsedTime = System.nanoTime() - startTime;
		System.out.println("...End fast exponential\n" + 
						"Total Time Taken: " + elapsedTime + "ns ("
							+ TimeUnit.MICROSECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS) + "micros)");
			
		//read out output and test
		System.out.println("Output: " + output);
	}
}
