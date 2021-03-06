package leetcode.Math;

public class ArrangeCoins {

	public static void main(String[] args) {
		long[] coins = {2,5,8,3,6};
		//arrangeCoinsPrinted(coins);
		arrangeCoins(coins);
		myArrangeCoins(coins);
	}	
	/*public int arrangeCoins(int n) {
		return (int) ((Math.sqrt(1 + 8.0 * n) - 1) / 2);
	}*/
	
	
	
	/**
	 * Complexity Analysis
	 * Uniform cost model is used as Cost Model and `n` is the input number. `b` in this case would be `2`.

	Time Complexity:
	
	Best Case `O(log_b(n))` : With respect to the input, the algorithm will always depend on the value of input.
	Average Case `O(log_b(n))` : With respect to the input, the algorithm will always depend on the value of input.
	Worst Case `O(log_b(n))` : With respect to the input, the algorithm will always depend on the value of input.
	Auxiliary Space:
	
	Worst Case `O(1)` : Additional variables are of constant size.
	Algorithm
	
	Approach: Binary Search
	 */
	public int arrangeCoins(int n) {
		int start = 0;
		int end = n;
		int mid = 0;
		while (start <= end){
			mid = (start + end) >>> 1;
			if ((0.5 * mid * mid + 0.5 * mid ) <= n){
				start = mid + 1;
			}else{
				end = mid - 1;
			}
		}
		return start - 1;
	}
	static void arrangeCoinsPrinted(long[] n){
		for(int k=0;k<n.length;k++){
			int count=1;
			int sum =0;
			long temp=n[k];
			for(int i=1;i<=n[k];i++){
				int j;
				for(j=1;j<=i;j++){
					if(temp>0){
						System.out.print("*");
						temp--;
					}
				}
				System.out.println();
				sum=sum+i;
				if(sum<=n[k]){
					count++;
				}
			}
			System.out.println("No of Stairs for :"+n[k]+" coins is "+(count-1));
		} 
	}

	static void arrangeCoins(long[] coins){

		for(int k = 0;k < coins.length;k++){
			int count = 1;
			int sum =0;
			for(int i = 1;i <= coins[k];i++){
				sum = sum + i;
				if(sum <= coins[k]){
					count++;
				}
			}
			System.out.println(count-1);
		}
	}

	static void myArrangeCoins(long[] coins){
		for(int i = 0; i < coins.length;i++){
			long coin = coins[i];
			int row = 1;
			for(long j = coin; j > 0; row++){
				if(row < j){
					j = j - row;
				} else if (row == j){
					System.out.println(row);
					break;
				} else {
					System.out.println(row - 1);
					break;
				}
			}
		}
	}

}