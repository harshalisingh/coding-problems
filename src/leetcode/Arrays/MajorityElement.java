package leetcode.Arrays;

/*
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times. 
 * (assume that the array is non-empty and the majority element always exist in the array.)
 */
public class MajorityElement {
	public int majorityElement(int[] nums) {
        int major=nums[0], count = 1; //[1, 2 , 1, 1, 1, 7, 1, 8]
        for(int i=1; i<nums.length; i++){
            if(count==0){
                count++;
                major=nums[i];
            }else if(major==nums[i]){
                count++;
            }else 
            	count--;          
        }
        return major;
    }
}
