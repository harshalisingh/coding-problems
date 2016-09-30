package epi.ArraysAndString;

public class RotateArray {
	public static void main(String[] args){
		int[] input = new int[]{1, 2, 3, 4, 5, 6, 7};
		rotate(input, 3);
		for(int i = 0; i < input.length; i++){
			System.out.print(input[i]);
		}
	}
	public static void rotate(int[] nums, int k) {      
        if(nums.length <= 1){
           return;
       }
       
       //step each time to move
       int step = k % nums.length;
       reverse(nums, 0, nums.length - 1);
       reverse(nums, 0, step-1);
       reverse(nums, step, nums.length - 1);
   }
   
   public static void reverse(int[] array, int start, int last){
	   while(start < last){
			int temp = array[start];
			array[start] = array[last];
			array[last] = temp;
			start++;
			last--;
		}
   }

}
