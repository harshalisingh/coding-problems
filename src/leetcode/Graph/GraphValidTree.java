package leetcode.Graph;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
 * write a function to check whether these edges make up a valid tree.
 * https://leetcode.com/problems/graph-valid-tree/description/

 * Check 2 things: 1. whether there is loop 2. whether the number of connected components is 1
 */
public class GraphValidTree {
	public boolean validTree(int n, int[][] edges) {
		UnionFind uf = new UnionFind(n);
		for (int[] edge: edges) {
			int x = edge[0], y = edge[1];
			if (!uf.union(x, y)) { return false; }  // loop detected
		}
		return uf.count == 1;
	}
}
