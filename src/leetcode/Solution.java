package leetcode;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

//input: string "1234"
//output: All possible decoded character combinations 
//1 => 'a', '2' => 'b', '10' => 'j', '20' => 't', '26' => 'z'
//  a,b,c,d
//  a,w,d
//  l,c,d

// 1 - a
// 2 - b
// 3 - c
// 4 - d

//Binary Tree Node
class TreeNode {
	String val;
	TreeNode left;
	TreeNode right;

	public TreeNode(String val){
		this.val = val;
	}

	public String getVal(){
		return val;
	}
}

class Solution {
	public static void main(String[] args) {
		String input = "1234";
		
		//converted to integer array for easy computation
		int[] intArray = new int[input.length()];
		for (int i = 0; i < input.length(); i++) {
			intArray[i] = Character.digit(input.charAt(i), 10);
		}
		
		//create Tree
		TreeNode tree = createTree(0, "", intArray);  
		printTree(tree);
	}
	private static final String[] alphabet = {"", "a", "b", "c", "d", "e",
			"f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
			"s", "t", "u", "v", "w", "x", "v", "z"};

	//prints leaves of tree
	public static void printTree(TreeNode root){
		if(root == null)
			return;

		if(root.left == null && root.right == null)
			System.out.println(root.getVal());

		printTree(root.left);
		printTree(root.right);
	}

	//creates tree to store all possible decoded combinations as leaves
	public static TreeNode createTree(int num, String pStr, int[] input){   
		if(num > 26)
			return null;

		//value of new node
		String nodeStr = pStr + alphabet[num];
		TreeNode root = new TreeNode(nodeStr);

		if(input.length != 0){
			num = input[0];
			int[] newArr = Arrays.copyOfRange(input, 1, input.length);
			
			//add left child
			root.left = createTree(num, nodeStr, newArr);

			if(input.length > 1){
				num = input[0] * 10 + input[1];
				newArr = Arrays.copyOfRange(input, 2, input.length);  
				
				//add right child
				root.right = createTree(num, nodeStr, newArr);
			}
		}
		return root; 
	}
}







