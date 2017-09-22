package leetcode.Graph;

/**
 * http://www.geeksforgeeks.org/union-find-algorithm-set-2-union-by-rank/
 * https://www.cs.princeton.edu/~rs/AlgsDS07/01UnionFind.pdf
 */
public class UnionFind {
	int[] parent;
	int[] rank;
	int count;

	UnionFind(int n) {
		parent = new int[n];
		rank = new int[n];
		count = n;  // number of components
		for (int i=0; i < n; ++i) { 
			parent[i] = i; // initially, each node's parent is itself.
		}  
	}

	/* A utility function to find set of an element x (uses path compression technique) */
	int find(int x) {
		// find root and make root as parent of x (path compression)
		if (x != parent[x]) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	/* A function that does union of two sets of x and y (uses union by rank) */
	boolean union(int x, int y) {
		int X = find(x), Y = find(y);
		if (X == Y) { return false; }
		if (rank[X] > rank[Y]) { parent[Y] = X; }  // tree Y is lower
		else if (rank[X] < rank[Y]) { parent[X] = Y; }  // tree X is lower
		else {  //If ranks are same, then make one as root and increment its rank by one
			parent[Y] = X;
			++rank[X];
		}
		--count;
		return true;
	}
}
