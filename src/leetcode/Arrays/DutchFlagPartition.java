package leetcode.Arrays;

public class DutchFlagPartition {
	
	public void sortColors(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        
        int pl = 0;
        int pr = a.length - 1;
        int i = 0;
        while (i <= pr) {
            if (a[i] == 0) {
                swap(a, pl, i);
                pl++;
                i++;
            } else if(a[i] == 1) {
                i++;
            } else {
                swap(a, pr, i);
                pr--;
            }
        }
    }
    
    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
	public static void dutchFlagPartition(int[] a, int lo, int hi){
		if (hi <= lo) return;
        int sm = lo, gt = hi;
        int v = a[lo];
        int eq = lo;
        while (eq <= gt) {
        	if(a[eq] < v){
        		swap(a, sm++, eq++);
        	} else if(a[eq] > v){
        		swap(a, gt--, eq);
        	} else {
        		++eq;
        	}
        }

        // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]. 
        dutchFlagPartition(a, lo, sm-1);
        dutchFlagPartition(a, gt+1, hi);
		
	}
	
	public static void main(String[] args){
		int[] input = {2, 0, 1, 0, 0, 0, 1, 1, 2, 1, 2};
		dutchFlagPartition(input, 0, input.length - 1);
		for(int i : input){
			System.out.print(i);
		}
	}
}
