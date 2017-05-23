package leetcode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	    if (node == null) return null;
	    return cloneGraph(node, new HashMap<>());
	}

	private UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> visited) {
	    if (visited.containsKey(node)) return visited.get(node);
	    
	    UndirectedGraphNode cloned = new UndirectedGraphNode(node.label);
	    
	    visited.put(node, cloned);
	    
	    for (UndirectedGraphNode neighbor : node.neighbors)
	        cloned.neighbors.add(cloneGraph(neighbor, visited));
	    
	    return cloned;
	}
}
