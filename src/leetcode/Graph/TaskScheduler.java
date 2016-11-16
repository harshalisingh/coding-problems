package leetcode.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class TaskScheduler {
	public static int[] findOrder(int[][] dependency) { 

		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < dependency.length; i++){
			set.add(dependency[i][0]);
			set.add(dependency[i][1]);
		}
		int numTasks = set.size();
		// Convert graph presentation from edges to indegree of adjacent list.
		Map<Integer, Integer> map = new HashMap<>();
		int order[] = new int[numTasks], index = 0;
		for (int i = 0; i < dependency.length; i++) {// Indegree - how many dependency are needed.
			//System.out.println(i + "," + dependency[i][1]);
			if(map.containsKey(dependency[i][1])){
				map.put(dependency[i][1], map.get(dependency[i][1]) + 1);
			} else {
				map.put(dependency[i][1], 1);
			}
		}   

		Queue<Integer> queue = new LinkedList<Integer>();
		for (Integer i : set) {
			if (!map.containsKey(i)) {
				// Add the course to the order because it has no dependency.
				order[index++] = i;
				queue.offer(i);
			}
		}


		// How many courses don't need dependency. 
		while (!queue.isEmpty()) {
			int prerequisite = queue.poll(); // Already finished this prerequisite course.
			for (int i = 0; i < dependency.length; i++)  {
				if (dependency[i][0] == prerequisite) {
					//System.out.println(dependency[i][1]);
					map.put(dependency[i][1], map.get(dependency[i][1]) - 1);
					if (map.get(dependency[i][1]) == 0) {
						// If indegree is zero, then add the course to the order.
						order[index++] = dependency[i][1];
						queue.offer(dependency[i][1]);
					}
				} 
			}
		}
		return (index == numTasks) ? order : new int[0];
	}

	public static void main(String[] args){
		int[][] dependency = {
				{19, 18},
				{20, 19},
				{17, 16},
				{9, 8},
				{11, 10},
				{13, 12},
				{7, 6},
				{2, 1},
				{6, 5},
				{3, 2},
				{8, 7},
				{25, 24},
				{21, 20},
				{10, 9},
				{12, 11},
				{14, 13},
				{23, 22},
				{15, 14},
				{18, 17},
				{16, 15},
				{22, 21},
				{24, 23},
				{25, 4},
				{4, 3}};
		int[] res = findOrder(dependency);
		for(int i = 0; i < res.length; i++){
			System.out.println(res[i]);
		}
	}
}
