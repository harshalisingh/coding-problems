package leetcode.Arrays;

import java.util.Arrays;

public class SeparatePositiveNegative {

	public void RearrangePosNeg(int arr[]){
		int key, j;
		for(int i = 1; i < arr.length; i++)
		{
			key = arr[i];

			if (key > 0)
				continue;


			j = i - 1;
			while (j >= 0 && arr[j] > 0)
			{
				arr[j + 1] = arr[j];
				j = j - 1;
			}

			arr[j + 1] = key;
		}
	}

	public static void main(String[] args){
		SeparatePositiveNegative obj = new SeparatePositiveNegative();
		int[] arr = new int[] {-3,4,3,-2,-8,6,13,-15};
		int[] arr1 = new int[] {1,-5,4,-3};
		//obj.RearrangePosNeg(arr);
		obj.RearrangePosNeg(arr1);
		//System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr1));
	}
}
