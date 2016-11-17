package epi.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//This One!! EPI Solution
public class Combination {
	public static void main(String[] args){
		List<Integer> input = Arrays.asList(0, 1, 2);
		combination(input);
	}
	public static void combination(List<Integer> inputSet){
		Map<Integer, Integer> countMap = new TreeMap<>();
		for (Integer ch : inputSet) {
			countMap.compute(ch, (key, val) -> {
				if (val == null) {
					return 1;
				} else {
					return val + 1;
				}
			});
		}
		int str[] = new int[countMap.size()];
		int count[] = new int[countMap.size()];
		int index = 0;
		for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
			str[index] = entry.getKey();
			count[index] = entry.getValue();
			index++;
		}
		List<List<Integer>> powerSet = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		combinationUtil(inputSet, 0, new ArrayList<Integer>(), powerSet);
		System.out.print(powerSet.size());
		for(List<Integer> set : powerSet){
			for(Integer num : set){
				System.out.print(num + ",");
			}
			System.out.println();
		}
	}

	private static void combinationUtil(List<Integer> inputSet, int pos, List<Integer> outputSet,
		List<List<Integer>> powerSet) {
		// TODO Auto-generated method stub
		if(pos == inputSet.size()){
			powerSet.add(new ArrayList<>(outputSet));
			return;
		}

		outputSet.add(inputSet.get(pos));
		combinationUtil(inputSet, pos + 1, outputSet, powerSet);
		outputSet.remove(outputSet.size()-1);
		combinationUtil(inputSet, pos + 1, outputSet, powerSet);

	}
}
