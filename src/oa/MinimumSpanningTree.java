package oa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * More than a dozen cities to supply, connect the different cost in different cities, so that it takes a minimum simultaneously connected to all sides. 
 * Given a series connection type, there is a cost between the name of the city across the edge and they find out you want to pick some edge, 
 * connect all the cities and the total cost to a minimum. Ring can not have, so the last city block to be connected to a communication. 
 * Not, then outputs an empty table and, finally, by city name sort output, according to node1 sort, if the same thing again ranked node2. 
	Input: 
	{ "Acity", "Bcity",. 1} 
	( "Acity", "cCity", 2} 
	( "Bcity", "cCity",. 3} 
	Output: 
	( "Acity", "Bcity",. 1} 
	( " Acity "," ccity ", 2 } 
	add that, test case a total of six
 */

/**
 * My idea is to use Kruskal + Union Find, will enter a group of connection class (in fact, is the edge) 
 * in accordance with the cost from small to large sort (Kruskal algorithm), and then traversal. 
 * Pick out a connection, look at the edge of the two cities belong to which group (Union Find). 
 * If the single to join, different groups on the merger, are off on the Baotuan. 
 * Finally, there are two requirements, 
 * 1. If MST does not exist, then output an empty table (should not be null). This can be used union find ideas, 
 * and finally check a few union, if we are their own people, then the normal output, if we are 1, there are sporadic 2, and that empty table. 
 * 2. Output in accordance with the name of the city sort, this is not difficult, the normal sort on the line.
 */

/**
 * Time Complexity: O(ElogE) or O(ElogV). Sorting of edges takes O(ELogE) time. 
 * After sorting, we iterate through all edges and apply find-union algorithm. 
 * The find and union operations can take atmost O(LogV) time. So overall complexity is O(ELogE + ELogV) time. 
 * The value of E can be atmost O(V2), so O(LogV) are O(LogE) same. Therefore, overall time complexity is O(ElogE) or O(ElogV)
 *
 */
class Connection{
	String node1;
	String node2;
	int cost;
	public Connection(String a, String b, int c){
		node1 = a;
		node2 = b;
		cost = c;
	}
}
public class MinimumSpanningTree {
	static class DisjointSet {
		class Node {
			String data;
			int rank;
			Node parent;
		}
		int count;
		private Map<String, Node> map = new HashMap<>();

		/**
		 * Create a set with only one element.
		 */
		public void makeSet(String data) {
			Node node = new Node();
			node.data = data;
			node.parent = node;
			node.rank = 0;
			map.put(data, node);
			count++;
		}

		/**
		 * Combines two sets together to one.
		 * Does union by rank
		 *
		 * @return true if data1 and data2 are in different set before union else false.
		 */
		public boolean union(String data1, String data2) {
			Node node1 = map.get(data1);
			Node node2 = map.get(data2);

			Node parent1 = findSet(node1);
			Node parent2 = findSet(node2);

			//if they are part of same set do nothing
			if (parent1.data.equals(parent2.data)) {
				return false;
			}

			//else whoever's rank is higher becomes parent of other
			if (parent1.rank >= parent2.rank) {
				//increment rank only if both sets have same rank
				parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
				parent2.parent = parent1;
			} else {
				parent1.parent = parent2;
			}

			count--;
			return true;
		}

		/**
		 * Finds the representative of this set
		 */
		public String findSet(String data) {
			return findSet(map.get(data)).data;
		}

		/**
		 * Find the representative recursively and does path
		 * compression as well.
		 */
		private Node findSet(Node node) {
			Node parent = node.parent;
			if (parent == node) {
				return parent;
			}
			node.parent = findSet(node.parent);
			return node.parent;
		}
	}

	static class costComparator implements Comparator<Connection>
	{
		@Override
		public int compare(Connection a, Connection b)
		{
			return a.cost - b.cost;
		}
	}
	static class nameComparator implements Comparator<Connection>
	{
		@Override
		public int compare(Connection a, Connection b)
		{
			if(a.node1.equals(b.node1)) 
				return a.node2.compareTo(b.node2);
			else 
				return a.node1.compareTo(b.node1);
		}
	}

	public static List<Connection> getMST(List<Connection> connections)
	{

		Comparator<Connection> costComparator = new costComparator();
		Comparator<Connection> nameComparator = new nameComparator();
		Collections.sort(connections, costComparator);
		DisjointSet ds = new DisjointSet();
		List<Connection> result = new ArrayList<>();
		Set<String> set = new HashSet<>();
		for(Connection c: connections)
		{
			ds.makeSet(c.node1);
			ds.makeSet(c.node2);
		}
		for(Connection c: connections)
		{
			String s = ds.findSet(c.node1);
			String t = ds.findSet(c.node2);
			if(!s.equals(t))
			{
				ds.union(s, t);
				result.add(c);
			}
		}

		if ((set.size() - 1) != result.size()){
			return null;
		}
		Collections.sort(result, nameComparator);
		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Connection> connections = new ArrayList<>();
		connections.add(new Connection("Acity","Bcity",1));
		connections.add(new Connection("Acity","Ccity",2));
		connections.add(new Connection("Bcity","Ccity",3));
		//        connections.add(new Connection("A","B",6));
		//        connections.add(new Connection("B","C",4));
		//        connections.add(new Connection("C","D",5));
		//        connections.add(new Connection("D","E",8));
		//        connections.add(new Connection("E","F",1));
		//        connections.add(new Connection("B","F",10));
		//        connections.add(new Connection("E","C",9));
		//        connections.add(new Connection("F","C",7));
		//        connections.add(new Connection("B","E",3));
		//        connections.add(new Connection("A","F",1));

		List<Connection> res = getMST(connections);
		for (Connection c : res){
			System.out.println(c.node1 + " -> " + c.node2 + " cost : " + c.cost);
		}
	}
}
