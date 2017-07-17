package leetcode.Arrays.MissingOrDuplicate;

import java.util.ArrayList;
import java.util.List;

/** Find All Duplicates in an Array
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements that appear twice in this array.
 * Could you do it without extra space and in O(n) runtime?
 */
public class FindAllDuplicatesInArray {
	// when find a number i, flip the number at position i-1 to negative. 
    // if the number at position i-1 is already negative, i is the number that occurs twice.
	
	public List<Integer> findDuplicateModifyingAray(int[] nums) {
		List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0){
                nums[val] = -nums[val];
            }
            else{
            	// If it is not greater than 0 (i.e) negative then the number is a duplicate
                res.add(Math.abs(nums[i]));
            }
        }
        return res;
    }
	
	public static void main(String[] args){
		FindAllDuplicatesInArray caller = new FindAllDuplicatesInArray();
		int[] nums = {4,3,2,7,8,2,3,1};
		System.out.println(caller.findDuplicateModifyingAray(nums).toString());
	}
}
