package leetcode.Graph;

import java.util.LinkedList;

//This class represents a directed graph using adjacency list
// representation
class Graph
{
	private int V;   // No. of vertices
	private LinkedList<Integer> adj[]; //Adjacency List

	//Constructor
	Graph(int v)
	{
		V = v;
		adj = new LinkedList[v];
		for (int i=0; i<v; ++i)
			adj[i] = new LinkedList<Integer>();
	}

	//Function to add an edge into the graph
	void addEdge(int v,int w)  {   adj[v].add(w);   }

	//prints BFS traversal from a given source s
	boolean isReachable(int s, int d)
	{
		if(s == d){
			return true;
		}
		// Mark all the vertices as not visited(By default set
		// as false)
		boolean visited[] = new boolean[V];

		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[s]=true;
		queue.add(s);
		while (!queue.isEmpty())
		{
			// Dequeue a vertex from queue and print it
			s = queue.poll();
			int neighbour;
			for(int i = 0; i < adj[s].size(); i++){
				neighbour = adj[s].get(i);
				// If this adjacent node is the destination node,
				// then return true
				if (neighbour == d)
					return true;

				// Else, continue to do BFS
				if (!visited[neighbour])
				{
					visited[neighbour] = true;
					queue.add(neighbour);
				}
			}
		}

		// If BFS is complete without visited d
		return false;
	}
}
public class IsPathDirectedGraph {
	// Driver method
	public static void main(String args[])
	{
		// Create a graph given in the above diagram
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		int u = 1;
		int v = 3;
		if (g.isReachable(u, v))
			System.out.println("There is a path from " + u +" to " + v);
		else
			System.out.println("There is no path from " + u +" to " + v);;

			u = 3;
			v = 1;
			if (g.isReachable(u, v))
				System.out.println("There is a path from " + u +" to " + v);
			else
				System.out.println("There is no path from " + u +" to " + v);;
	}
}
