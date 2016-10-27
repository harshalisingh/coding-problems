package leetcode.Math;

public class ArrangeCoins {

	public static void main(String[] args) {
		long[] coins = {2,5,8,3,6};
		//arrangeCoinsPrinted(coins);
		arrangeCoins(coins);
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