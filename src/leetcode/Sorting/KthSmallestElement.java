package leetcode.Sorting;

//http://algorithms.tutorialhorizon.com/find-kth-smallest-or-largest-element-in-an-array/
//O(n)
public class KthSmallestElement {

	public int findkthSmallestElement(int[] arrA, int k) {
		//k = k - 1;           // Kth element from start (Kth smallest)
		k = arrA.length - k;   //Kth element from end    (Kth largest)
		return getKth(arrA, 0, arrA.length - 1, k);
	}

	public int getKth(int[] arrA, int start, int end, int k) {
		int left = start;
		int right = end;
		int pivot = start;
		while (left <= right) {
			while (left <= right && arrA[left] <= arrA[pivot])
				left++;
			while (left <= right && arrA[right] >= arrA[pivot])
				right--;
			if (left < right) {
				swap(arrA, left, right);
				left++;
				right--;
			}
		}
		swap(arrA, pivot, right);
		if (pivot == k)
			return arrA[pivot];// if pivot is kth element , return
		else if (pivot < k)
			// if pivot is less than k, then kth element will be on the right
			return getKth(arrA, pivot + 1, end, k);
		else
			// if pivot is greater than k, then kth element will be on the right
			return getKth(arrA, start, pivot - 1, k);
	}

	public void swap(int[] arrA, int a, int b) {
		int x = arrA[a];
		arrA[a] = arrA[b];
		arrA[b] = x;
	}

	public static void main(String args[]) {
		int[] arrA = { 2, 3, 11, 16, 27, 4, 15, 9, 8 };
		KthSmallestElement k = new KthSmallestElement();
		int a = 4;
		int x = k.findkthSmallestElement(arrA, a);
		System.out.print("The " + a + "th smallest element is : " + x);
	}
}