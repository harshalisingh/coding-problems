package leetcode.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class DeleteFromAUsingBLocation {
	public static void main(String[] args){
		testRemoveFromListA();
	}
	public static void removeFromListA(ArrayList<Integer> listA, int[] listB){
		int pre = 0;
		
		
		for(int i=0; i<listB.length; i++){
			int index = listB[i]-pre;
			
			if(index >= 0 && index < listA.size()){
				listA.remove(index);
			}
			
			pre = pre+1;
		}
	}
	
	public static void testRemoveFromListA(){
		ArrayList<Integer> listA = new ArrayList<Integer>();
		listA.add(2);
		listA.add(3);
		listA.add(5);
		listA.add(7);
		listA.add(8);
		
		int[] listB = {0,2,3};
		
		// expected result of listA [2,5,8];
		removeFromListA(listA, listB);
		
		System.out.println("listA after removal operation: " + listA);
	}
}
