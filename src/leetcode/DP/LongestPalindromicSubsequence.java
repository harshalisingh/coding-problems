package leetcode.DP;

/*
 * Time Complexity of the above implementation is O(n^2)
 */
public class LongestPalindromicSubsequence {

	//Bottom-Up
	public int lpsBottomUp(char []str){
		int T[][] = new int[str.length][str.length];
		for(int i=0; i < str.length; i++){
			T[i][i] = 1;
		}
		for(int l = 2; l <= str.length; l++){
			for(int i = 0; i < str.length-l + 1; i++){
				int j = i + l - 1;
				if(l == 2 && str[i] == str[j]){
					T[i][j] = 2;
				}else if(str[i] == str[j]){
					T[i][j] = T[i + 1][j-1] + 2;
				}else{
					T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
				}
			}
		}
		return T[0][str.length-1];
	}

	//Top-Down
	public int lpsTopDown(char str[],int i,int j){
		int[][] DP = new int[str.length][str.length];
		for(int k=0; k < str.length; k++){
			DP[k][k] = -1;
		}

		if(i > j) return 0;
		if(i == j)return 1;
		if(DP[i][j] != 0)
			return DP[i][j];

		if(str[i] == str[j]){
			DP[i][j] = 2 + lpsTopDown(str,i+1,j-1);
		} else{
			DP[i][j] =  Math.max(lpsTopDown(str, i+1, j), lpsTopDown(str, i, j-1));
		}

		return DP[i][j];

	}

	public static void main(String args[]){
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
		String str = "agbdba";
		int r1 = lps.lpsTopDown(str.toCharArray(), 0, str.length() - 1);
		int r2 = lps.lpsBottomUp(str.toCharArray());
		System.out.print(r1 + " " + r2);
	}

}
