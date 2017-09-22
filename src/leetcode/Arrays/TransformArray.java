package leetcode.Arrays;

import java.util.Arrays;

public class TransformArray {
	public static void main(String[] args) {
		TransformArray obj = new TransformArray();
		int[] ar = new int[]{1,2,0,0,2,3};
		obj.transformArray(ar);
		System.out.println(Arrays.toString(ar));
	}

	private static void transformArray(int[] ar) {
		int zeroPos = ar.length;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] == 0) {
				if (zeroPos == ar.length)
					zeroPos = i;
			} else {
				if (i == 0)
					continue;

				if (zeroPos == ar.length) {
					if (ar[i] == ar[i - 1]) {
						ar[i - 1] = 2 * ar[i - 1];
						ar[i] = 0;
						zeroPos = i;
					}
				} else {
					if (zeroPos != 0 && ar[i] == ar[zeroPos - 1]) {
						ar[zeroPos - 1] = 2 * ar[zeroPos - 1];
						ar[i] = 0;
					} else {
						ar[zeroPos] = ar[i];
						zeroPos++;
					}
				}
			}
		}

		while (zeroPos < ar.length)
			ar[zeroPos++] = 0;
	}
}
