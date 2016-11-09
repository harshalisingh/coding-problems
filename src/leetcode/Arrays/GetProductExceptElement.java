package leetcode.Arrays;

//https://www.interviewcake.com/question/java/product-of-other-numbers
public class GetProductExceptElement {
	  public int[] getProductsOfAllIntsExceptAtIndex(int[] intArray) {

		    // we make an array with the length of the input array to
		    // hold our products
		    int[] productsOfAllIntsExceptAtIndex = new int[intArray.length];

		    // for each integer, we find the product of all the integers
		    // before it, storing the total product so far each time
		    int productSoFar = 1;
		    for (int i = 0; i < intArray.length; i++) {
		        productsOfAllIntsExceptAtIndex[i] = productSoFar;
		        productSoFar *= intArray[i];
		    }

		    // for each integer, we find the product of all the integers
		    // after it. since each index in products already has the
		    // product of all the integers before it, now we're storing
		    // the total product of all other integers
		    productSoFar = 1;
		    for (int i = intArray.length - 1; i >= 0; i--) {
		        productsOfAllIntsExceptAtIndex[i] *= productSoFar;
		        productSoFar *= intArray[i];
		    }

		    return productsOfAllIntsExceptAtIndex;
		}

}
