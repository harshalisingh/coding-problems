package leetcode.ArraySpecial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Pair implements Comparable<Pair>{
    int sum;
    int index;
    public Pair(int s, int i){
        sum = s;
        index = i;
    }

    public int compareTo(Pair other){
        return this.sum - other.sum;
    }
}

public class SubArrayClosestSumZero {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (nums.length==0) return res;

        Pair[] sums = new Pair[nums.length+1];
        sums[0] = new Pair(0,-1);
        int sum = 0;
        for (int i=0;i<nums.length;i++){
            sum += nums[i];
            sums[i+1] = new Pair(sum,i);
        }

        Arrays.sort(sums);
        int min = Math.abs(sums[0].sum - sums[1].sum);
        int start =  Math.min(sums[0].index, sums[1].index)+1;
        int end = Math.max(sums[0].index, sums[1].index);
        for (int i=1;i<nums.length;i++){
            int diff = Math.abs(sums[i].sum - sums[i+1].sum);
            if (diff<min){
                min = diff;
                start = Math.min(sums[i].index, sums[i+1].index)+1;
                end  = Math.max(sums[i].index, sums[i+1].index);
            }
        }

        res.add(start);
        res.add(end);
        return res;
    }
    
    public static void main(String[] args){
    	SubArrayClosestSumZero o = new SubArrayClosestSumZero();
    	int[] nums = {-3, 1, 1, -3, 5};
    	List<Integer> res = o.subarraySumClosest(nums);
    	System.out.println(res.toString());
    }
}
