package epi;

public class RotateArray {
	public void rotate(int[] nums, int k) {
        
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
       
       if(start > last){
           return;
       }
       
       for(int i = start; i <= start + (last - start)/2; i++){
           int temp = array[i];
           array[i] = array[last - i + start];
           array[last - i + start] = temp;
       }
   }

}
