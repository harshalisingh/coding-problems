package leetcode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * https://leetcode.com/problems/clone-graph/#/description
 */
class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
public class CloneGraph {

	public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {
		if (node == null) return null;
		return cloneGraph(node, new HashMap<>());
	}

	private UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> visited) {
		if (visited.containsKey(node)) return visited.get(node);  // if we have already explored this vertex grab its clone from map

		UndirectedGraphNode cloned = new UndirectedGraphNode(node.label);	
		//map node to cloned node instead of label to cloned node in case of duplicate labels
		visited.put(node, cloned);   // visited = true;

		for (UndirectedGraphNode neighbor : node.neighbors) {
			cloned.neighbors.add(cloneGraph(neighbor, visited)); // explore unvisited vertex
		}
		return cloned;
	}

	//Use HashMap to look up nodes and add connection to them while performing BFS.
	public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node) {
		if (node == null) return null;

		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>(); // origin node : copied node
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label); // copy	

		map.put(node, newNode); //add first node to HashMap

		Queue<UndirectedGraphNode> queue = new LinkedList<>(); //to store **original** nodes need to be visited
		queue.add(node); //add first **original** node to queue

		while (!queue.isEmpty()) { //if more nodes need to be visited
			UndirectedGraphNode cur = queue.poll(); //search first node in the queue
			// all neighbors of current origin node
			for (UndirectedGraphNode neighbor : cur.neighbors) {
				// if the origin node is not visited
				if (!map.containsKey(neighbor)) { //add to map and queue if this node hasn't been searched before
					map.put(neighbor, new UndirectedGraphNode(neighbor.label));
					// to avoid loop, we just add the unvisited node to queue
					queue.offer(neighbor);
				}
				// add neighbors to the copied node
				// copied node: map.get(cur) -> copied node of cur
				// neighbors: map.get(neighbor) -> copied node of neighbor
				map.get(cur).neighbors.add(map.get(neighbor.label)); //add neighbor to new created nodes
			}
		}
		return newNode;
	}
}
