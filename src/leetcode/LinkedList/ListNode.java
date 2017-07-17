package leetcode.LinkedList;

public class ListNode {
	public int val;
	public ListNode next;
	ListNode(int x) { val = x; }
	public static void printList(ListNode L) {
		while (L != null) {
			System.out.print(L.val);
			System.out.print("--->");
			L = L.next;
		}
		System.out.print("null");
		System.out.println();

	}
}
