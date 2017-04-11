package oa;

import java.util.ArrayList;

/*
 * Topic: is to give more than one tree, represents the superior-subordinate relationship within the company. 
 * Each node represents a staff member node is contained in his work a few months (int), and a subordinate array (ArrayList)。
 * The goal is to find a subtree met: the average number of work-months subtree of all nodes in the tree is the largest of all the sub-tree. 
 * Finally, return to the sub-tree root node of the tree.
 * This title add that the return can not be a leaf node (leaf node because there is no subordinate), it must be a child node.
 */
class Node { 
    int val;
    ArrayList<Node> children;
    public Node(int val){
        this.val = val;
        children = new ArrayList<Node>();
    }
}
public class MaximumSubtreeAverage {
    static class Record
    {
        int sum;
        int count;
        public Record(int sum, int count)
        {
            this.sum = sum;
            this.count = count;
        }
    }
    static Node ans;
    static double max;
    public static Node find(Node root)
    {
        // Initialize static variables is very important for AMZAON OA!
        ans = null;
        max = 0;
        DFS(root);
        return ans;
    }
    private static Record DFS(Node root)
    {
        if(root == null) return new Record(0, 0);
        if(root.children == null || root.children.size() == 0) return new Record(root.val, 1);
        int sum = root.val;
        int count = 1;
        for(Node itr: root.children)
        {
            Record rec = DFS(itr);
            sum += rec.sum;
            count += rec.count;
        }
        if(count > 1 && (sum + 0.0) / count > max)
        {
            max = (sum + 0.0) / count;
            ans = root;
        }
        return new Record(sum, count);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node l21 = new Node(2);
        Node l22 = new Node(3);
        Node l23 = new Node(4);
        Node l31 = new Node(5);
        Node l32 = new Node(5);
        Node l33 = new Node(5);
        Node l34 = new Node(5);
        Node l35 = new Node(5);
        Node l36 = new Node(5);
 
        l21.children.add(l31);
        l21.children.add(l32);
 
        l22.children.add(l33);
        l22.children.add(l34);
 
        l23.children.add(l35);
        l23.children.add(l36);
 
        root.children.add(l21);
        root.children.add(l22);
        root.children.add(l23);
 
        Node res = find(root);
        System.out.println(res.val + " " + max);
    }
}
