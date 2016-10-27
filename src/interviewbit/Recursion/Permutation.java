package interviewbit.Recursion;

import java.util.ArrayList;

//https://github.com/mission-peace/interview/blob/master/src/com/interview/recursion/StringPermutation.java
public class Permutation {
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
		int[] count = new int[a.size()];
		int[] arr = new int[a.size()];
		int index = 0;
		for(int ia : a){
			count[index] = 1;
			arr[index] = ia;
			index++;
		}

		ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
		int[] result = new int[a.size()];
		permuteUtils(arr, count, result, 0, resultList);

		return resultList;
	}
	public static void permuteUtils(int[] arr, int[] count, int[] result, int level, ArrayList<ArrayList<Integer>> resultList){

		if(level == result.length){
			resultList.add(new ArrayList<Integer>(convertArrayToList(result)));
			return;
		}

		for(int i = 0; i < arr.length; i++){
			if(count[i] == 0){
				continue;
			}
			result[level] = arr[i];
			count[i]--;
			permuteUtils(arr, count, result, level+1, resultList);
			count[i]++;

		}
	}

	public static ArrayList<Integer> convertArrayToList(int[] intArray){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i : intArray){
			list.add(i);
		}
		return list;
	}
}
