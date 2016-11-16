package leetcode.LinkedList;

public class TripletSumLinkedList {
	 /* A function to chech if there are three elements in a, b
    and c whose sum is equal to givenNumber.  The function
    assumes that the list b is sorted in ascending order and
    c is sorted in descending order. */
 boolean isSumSorted(ListNode la, ListNode lb, ListNode lc,
                     int givenNumber)
 {
    ListNode a = la;

    // Traverse all nodes of la
    while (a != null)
    {
        ListNode b = lb;
        ListNode c = lc;

        // for every node in la pick 2 nodes from lb and lc
        while (b != null && c!=null)
        {
            int sum = a.val + b.val + c.val;
            if (sum == givenNumber)
            {
               System.out.println("Triplet found " + a.val +
                                   " " + b.val + " " + c.val);
               return true;
            }

            // If sum is smaller then look for greater value of b
            else if (sum < givenNumber)
              b = b.next;

            else
              c = c.next;
        }
        a = a.next;
    }
    System.out.println("No Triplet found");
    return false;
 }
}
