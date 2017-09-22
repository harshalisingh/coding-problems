package leetcode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class CourseScheduleII {
	public int[] findOrderBFS(int numCourses, int[][] prerequisites) { 
		if (numCourses == 0) return null;
		
		// Convert graph presentation from edges to indegree of adjacent list.
		Map<Integer, Integer> indegree = new HashMap<>();
		int[] order = new int[numCourses]; int index = 0;   

		//Only add dependents in the indegree map
		for (int i = 0; i < prerequisites.length; i++) {// Indegree - how many prerequisites are needed.
			if(indegree.containsKey(prerequisites[i][0])){
				indegree.put(prerequisites[i][0], indegree.get(prerequisites[i][0]) + 1);
			} else {
				indegree.put(prerequisites[i][0], 1);
			}
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i++) {
			if (!indegree.containsKey(i)) {
				// Add the course to the order because it has no prerequisites.
				order[index++] = i;
				queue.offer(i);
			}
		}

		// How many courses don't need prerequisites. 
		while (!queue.isEmpty()) {
			int prerequisite = queue.poll(); // Already finished this prerequisite course.
			for (int i = 0; i < prerequisites.length; i++)  {
				if (prerequisites[i][1] == prerequisite) {				
					indegree.put(prerequisites[i][0], indegree.get(prerequisites[i][0]) - 1);

					// If indegree is zero, then add the course to the order.
					if (indegree.get(prerequisites[i][0]) == 0) {						
						order[index++] = prerequisites[i][0];
						queue.offer(prerequisites[i][0]); 
					}
				} 
			}
		}

		return (index == numCourses) ? order : new int[0];
	}

	/*
	 * 0 - denotes not visited
	 * 1 - denotes visiting
	 * 2 - denotes visited
	 */
	public int[] findOrderDFS(int numCourses, int[][] prerequisites) {
		List<List<Integer>> adj = new ArrayList<List<Integer>>(numCourses);

		for (int i = 0; i < numCourses; i++) 
			adj.add(i, new ArrayList<>());

		for (int i = 0; i < prerequisites.length; i++) 
			adj.get(prerequisites[i][1]).add(prerequisites[i][0]);

		int[] visited = new int[numCourses];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < numCourses; i++) {
			if (!topologicalSort(adj, i, stack, visited)) return new int[0];
		}
		int i = 0;
		int[] result = new int[numCourses];
		while (!stack.isEmpty()) {
			result[i++] = stack.pop();
		}
		return result;
	}

	private boolean topologicalSort(List<List<Integer>> adj, int v, Stack<Integer> stack, int[] visited) {
		if (visited[v] == 2) return true;
		if (visited[v] == 1) return false;
		visited[v] = 1;
		for (Integer u : adj.get(v)) {
			if (!topologicalSort(adj, u, stack, visited)) return false;
		}
		visited[v] = 2;
		stack.push(v);
		return true;
	}
}
