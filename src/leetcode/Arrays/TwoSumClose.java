package leetcode.Arrays;

import java.util.Arrays;

/*
 * Given some capacity (double capacity), there is an array (double[] weights), and int numOfContainers
 * Find sum of two selected weights less than capacity in the array but assigned to the closest capacity and return a Container object.
 */
class Container {
    public double first;
    public double second;
    public Container(double first, double second)
    {
        this.first = first;
        this.second = second;
    }
}
public class TwoSumClose {
	public static Container findOptimalWeights(double capacity, double[] weights, int numOfContainers){
		
		if(weights == null || weights.length <= 2) return null;
        Arrays.sort(weights);
        if(weights[0] + weights[1] > capacity) return null;

        double min = 0.0;
        int minPos = 0;
        int maxPos = weights.length - 1;
        int i = 0 , j = weights.length-1;
        while(i < j){
            double sum = weights[i] + weights[j];

            if(sum > min && sum <= capacity){
                min = sum;
                minPos = i;
                maxPos = j;
            }

            if(sum > capacity){
                j--;
            }else {
                i++;
            }
        }

        return new Container(weights[minPos], weights[maxPos]);
    }
	
	public static void main(String[] args)
    {
        Container res = findOptimalWeights(35, new double[]{10, 24, 30, 9, 19, 23, 7}, 8);
        System.out.println(res.first+" "+res.second);
    }
}
