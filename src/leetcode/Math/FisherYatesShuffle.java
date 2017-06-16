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

/* Fisher Yates Shuffle
 * https://www.evernote.com/Home.action#n=aa7a5ff5-7efb-4b52-848c-fa87c9439380&b=f4167978-447b-4e84-9e91-a3b79bfe118f&ses=4&sh=1&sds=2&
 * O(n) time and O(1) space.
 */
class FisherYatesInPlaceShuffle {
	private static Random rand = new Random();

	private static int getRandom(int floor, int ceiling) {
	    return rand.nextInt((ceiling - floor) + 1) + floor;
	}

	public static void shuffle(int[] theArray) {

	    // if it's 1 or 0 items, just return
	    if (theArray.length <= 1) {
	        return;
	    }

	    // walk through from beginning to end
	    for (int indexWeAreChoosingFor = 0; indexWeAreChoosingFor < theArray.length - 1; indexWeAreChoosingFor++) {

	        // choose a random not-yet-placed item to place there
	        // (could also be the item currently in that spot)
	        // must be an item AFTER the current item, because the stuff
	        // before has all already been placed
	        int randomChoiceIndex = getRandom(indexWeAreChoosingFor, theArray.length - 1);

	        // place our random choice in the spot by swapping
	        if (randomChoiceIndex != indexWeAreChoosingFor) {
	            int valueAtIndexWeChoseFor = theArray[indexWeAreChoosingFor];
	            theArray[indexWeAreChoosingFor] = theArray[randomChoiceIndex];
	            theArray[randomChoiceIndex] = valueAtIndexWeChoseFor;
	        }
	    }
	}




}
