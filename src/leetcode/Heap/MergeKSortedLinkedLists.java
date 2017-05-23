package leetcode.Heap;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import leetcode.LinkedList.ListNode;

public class MergeKSortedLinkedLists {
	public ListNode mergeKLists(List<ListNode> lists) {
        if(lists.size() == 0)   //base case
            return null;
        
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(11, new Comparator<ListNode>(){
        	@Override
          public int compare(ListNode o1, ListNode o2) {
              return Integer.compare(o1.val, o2.val);
          }
        });
        
        //Adding first node of each list
        for(ListNode node: lists) {
            if(node != null)
                queue.add(node);
        }
        
        if(queue.isEmpty())     //checking if queue is not empty. base case
            return null;

        //Get the smallest node (result) which will be our head of new list 
        //and add its next node to queue
        ListNode result = queue.poll();
        if(result.next != null)
            queue.add(result.next);

        ListNode cur = result;

        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            if(node.next != null) {
                queue.add(node.next);
                node.next = null;
            }
            cur.next = node;
            cur = cur.next;
        }

        return result;
    }

//    private class ListNodeComparer implements Comparator<ListNode> {
//        @Override
//        public int compare(ListNode o1, ListNode o2) {
//            return Integer.compare(o1.val, o2.val);
//        }
//    }
}
