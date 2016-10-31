package leetcode.DP;

public class HouseRobber {
	public int rob(int[] num) {
        int i = 0;
        int e = 0;
        for (int k = 0; k<num.length; k++) {
            int tmp = i;
            i = num[k] + e;
            e = Math.max(tmp, e);
        }
        return Math.max(i,e);
    }
}
