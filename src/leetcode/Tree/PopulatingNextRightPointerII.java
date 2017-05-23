package leetcode.Tree;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/#/description
 * O(1) space and O(n) Time complexity
 */
public class PopulatingNextRightPointerII {
	//based on level order traversal
	
	public void connect(TreeLinkNode root) {
        // Logic: 
        //        node moves to all nodes in tree in level order fashion
        //        needle keeps sewing together next level's children

        // levelHead is sentinel, keeps track of start node of next level
        TreeLinkNode node = root, levelHead = new TreeLinkNode(0);
        
        while(node != null){ // this loop is for different levels
        
            // needle is sewing next fields in current level
            // first time in a level, it is same as leavelHead (with null next)
            // but as soon as we get a non null child from node
            // needle threads that child into its next, 
            //      --------->>  thus making that child as next levelHead
            //
            TreeLinkNode needle = levelHead;
        
            // this loop moves node in current level
            while(node != null){
                
                if(node.left != null){
                    needle.next = node.left;
                    needle = needle.next;
                }
                if(node.right != null){
                    needle.next = node.right;
                    needle = needle.next;
                }
                
                node = node.next; // move node to next in same level, end up null at rightmost
            }
            // current level ended in node being null
            // take node fom sentinel's next, which is next levels start
            node = levelHead.next;
            
            // levelhead.next grabbed into node above, it has been used
            // so make it null so next time we dont grab again, 
            //    if all next lvl is null, it remains null prompting end of run
            levelHead.next = null;  
        }
    }
}
