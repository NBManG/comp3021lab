package lab9;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 * COMP 3021
 * 
This is a class that prints the maximum value of a given array of 90 elements

This is a single threaded version.

Create a multi-thread version with 3 threads:

one thread finds the max among the cells [0,29] 
another thread the max among the cells [30,59] 
another thread the max among the cells [60,89]

Compare the results of the three threads and print at console the max value.

 * 
 * @author valerio
 *
 */
public class FindMax {
	private int max1;
	private int max2;
	private int max3;
	
	// this is an array of 90 elements
	// the max value of this array is 9999
	static int[] array = { 1, 34, 5, 6, 343, 5, 63, 5, 34, 2, 78, 2, 3, 4, 5, 234, 678, 543, 45, 67, 43, 2, 3, 4543,
			234, 3, 454, 1, 2, 3, 1, 9999, 34, 5, 6, 343, 5, 63, 5, 34, 2, 78, 2, 3, 4, 5, 234, 678, 543, 45, 67, 43, 2,
			3, 4543, 234, 3, 454, 1, 2, 3, 1, 34, 5, 6, 5, 63, 5, 34, 2, 78, 2, 3, 4, 5, 234, 678, 543, 45, 67, 43, 2,
			3, 4543, 234, 3, 454, 1, 2, 3 };

	public static void main(String[] args) {
	
		new FindMax().printMax2();
		
		
	}

	public void printMax() {
		// this is a single threaded version
		int max = findMax(0, array.length - 1);
		System.out.println("the max value is " + max);
	}
	
	public void printMax2() {
		// this is a multiple threaded version
		
		Runnable rn1 = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				max1 = findMax(0, 29);
			}
		};
		Runnable rn2 = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				max2 = findMax(30, 59);
			}
		};
		Runnable rn3 = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				max3 = findMax(60, 89);
			}
		};

		ExecutorService ex = Executors.newFixedThreadPool(3);
		ex.execute(rn1);
		ex.execute(rn2);
		ex.execute(rn3);
		try {
			ex.awaitTermination(10, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int max = max1;
		if (max < max2)
			max = max2;
		if (max < max3)
			max = max3;
		System.out.println("the max value is " + max);
	}

	/**
	 * returns the max value in the array within a give range [begin,range]
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	private int findMax(int begin, int end) {
		// you should NOT change this function
		int max = array[begin];
		for (int i = begin + 1; i <= end; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}
}
