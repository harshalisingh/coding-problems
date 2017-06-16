package leetcode.ArraySpecial;

public class LongestIncreasingSubarray {
	public static int lengthLongestIncreasingSubArray(int[] A){
		if(A == null) return 0;
		if(A.length == 1) return 1;
		
		int start = 0, end = 1, maxLength = 1;
		while(end < A.length){
			if(A[end] > A[end - 1]){
				if(end - start + 1 > maxLength)
					maxLength = end - start + 1;
			} else {
				start = end;
			}
			
			end++;
		}
		//System.out.println(start + "," + end);
		return maxLength;	
	}
	
	private static class SubArray{
		int start, end;
		public SubArray(int start, int end){
			this.start = start;
			this.end = end;
		}
	}
	
	public static SubArray longestIncreasingSubArray(int[] A){
		int maxLength = 1;
		SubArray ans = new SubArray(0,0);
		int i = 0;
		while(i < A.length - maxLength){
			boolean isSkippable = false;
			for(int j = i + maxLength;  j > i; --j){
				if(A[j - 1] >= A[j]){
					i = j;
					isSkippable = true;
					break;
				}
			}
			
			if(!isSkippable){
				i += maxLength;
				while(i < A.length && A[i - 1] < A.length){
					++i;
					++maxLength;
				}
				ans = new SubArray(i - maxLength, i - 1);
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args){
		int[] nums = {-1, 1, 2, 3, 5, 8, 7, 9};
		System.out.println(lengthLongestIncreasingSubArray(nums));
		//SubArray ans = longestIncreasingSubArray(nums);
		//System.out.println(ans.start + "," + ans.end);
	}
}
