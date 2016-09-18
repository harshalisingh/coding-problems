package epi;

public class RemoveElementArray {
	
public int removeElement(int[] nums, int val) {
        
        if(nums.length == 1){
            if(nums[0] == val){
                return 0;
            } else {return 1; }
        }
        
        int writeIndex = 0;
        for(int i = 0; i< nums.length; i++){
            if(nums[i] != val){
                nums[writeIndex++] = nums[i];
            }
        }
        
        return writeIndex;
    }

}
