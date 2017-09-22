package leetcode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * https://leetcode.com/problems/course-schedule/#/description
 * Some courses may have prerequisites, 
 * for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * This problem is equivalent to finding if a cycle exists in a directed graph. 
 * If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
 * BFS
 */
public class CourseSchedule {
	public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
		Map<Integer, Integer> indegree = new HashMap<>();

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
				queue.offer(i);
			}
		}

		int count = 0;
		while(!queue.isEmpty()) {
			int prerequisite = queue.poll(); // Already finished this prerequisite course.
			count++;
			for (int i = 0; i < prerequisites.length; i++)  { //find all it's dependents and reduce the indegree
				if (prerequisites[i][1] == prerequisite) {				
					indegree.put(prerequisites[i][0], indegree.get(prerequisites[i][0]) - 1);

					if (indegree.get(prerequisites[i][0]) == 0) {
						queue.offer(prerequisites[i][0]); 
					}
				} 
			}
		}

		return count == numCourses;
	}

	public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
		ArrayList[] graph = new ArrayList[numCourses];
		for(int i=0;i<numCourses;i++)
			graph[i] = new ArrayList();

		boolean[] visited = new boolean[numCourses];
		for(int i=0; i<prerequisites.length;i++){
			//prerequisite(i,1) -> dependent(i,0)
			graph[prerequisites[i][1]].add(prerequisites[i][0]);
		}

		for(int i=0; i<numCourses; i++){
			if(!dfs(graph,visited,i))
				return false;
		}
		return true;
	}

	private boolean dfs(ArrayList[] graph, boolean[] visited, int course){
		if(visited[course])
			return false;
		else
			visited[course] = true;;

			for(int i=0; i<graph[course].size();i++){
				if(!dfs(graph,visited,(int)graph[course].get(i)))
					return false;
			}
			visited[course] = false;
			return true;
	}
}
