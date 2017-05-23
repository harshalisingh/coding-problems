package leetcode.Math;

import java.util.Random;

/*
 * http://algs4.cs.princeton.edu/11model/Knuth.java.html
 * http://www.geeksforgeeks.org/shuffle-a-given-array/
 * https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
 */
public class FisherYatesShuffle {
	private static void shuffleArray(int[] array)
	{
	    int index, temp;
	    Random random = new Random();
	    for (int i = array.length - 1; i > 0; i--)
	    {
	    	//returns a unique random number between 0 (inclusive)
	    	// and bound (exclusive)
	        index = random.nextInt(i + 1);
	        temp = array[index];
	        array[index] = array[i];
	        array[i] = temp;
	    }
	}
}
