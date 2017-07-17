package leetcode.Arrays;

import java.util.Arrays;

public class SeparatePositiveNegative {
	public static void separateArray(int[] numbers) {
	    int i = 0;
	    int j = numbers.length-1;
	    while(i<j){

	        if(numbers[i] >= 0 && numbers[j] < 0){
	            int temp;
	            temp = numbers[j];
	            numbers[j] = numbers[i];
	            numbers[i] = temp;
	        }

	        if(numbers[i] < 0){
	            i++;
	        }

	        if(numbers[j] >= 0){
	            j--;
	        }
	    }
	}

	private void swap(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args){
		SeparatePositiveNegative spn = new SeparatePositiveNegative();
		int[] arr = new int[] {-3,4,3,-2,-8,6,13,-15};
		int[] arr1 = new int[] {1, -5, 6, -4, 8, 9, 4, -2};
		spn.separateArray(arr1);
		
		System.out.println(Arrays.toString(arr1));
	}
}
