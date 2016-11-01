package leetcode.Tree;

public class ClosestBST {
	int goal;
    double min = Double.MAX_VALUE;
 
    public int closestValueRecursive(TreeNode root, double target) {
        helper(root, target);
        return goal;
    }
 
    public void helper(TreeNode root, double target){
        if(root==null)
            return;
 
        if(Math.abs(root.data - target) < min){
            min = Math.abs(root.data - target);
            goal = root.data;
        } 
 
        if(target < root.data){
            helper(root.left, target);
        }else{
            helper(root.right, target);
        }
    }
    
    public int closestValueIterative(TreeNode root, double target) {
        double min=Double.MAX_VALUE;
        int result = root.data;
     
        while(root!=null){
            if(target > root.data){
     
                double diff = Math.abs(root.data - target);
                if(diff<min){
                    min = Math.min(min, diff);
                    result = root.data;
                }
                root = root.right;
            }else if(target < root.data){
     
                double diff = Math.abs(root.data - target);
                if(diff<min){
                    min = Math.min(min, diff);
                    result = root.data;
                }
                root = root.left;
            }else{
                return root.data;
            }
        }    
        return result;
    }
    
    
}
