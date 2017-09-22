package leetcode.Graph;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
 * write a function to find the number of connected components in an undirected graph.
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/description/
 */
public class ConnectedComponentsInUndirectedGraph {
	public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
		for (int[] edge: edges) {
			int x = edge[0], y = edge[1];
            uf.union(x, y);
		}
		return uf.count;
    }
}
