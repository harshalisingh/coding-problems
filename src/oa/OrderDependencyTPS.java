package oa;

import java.util.*;


/**
 * This problem is equivalent to finding the topological order in a directed graph. 
 * If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
 * if a node has incoming edges, it has prerequisites. Therefore, the first few in the order must be those with no prerequisites, 
 * i.e. no incoming edges. If we visit these few and remove all edges attached to them, we are left with a smaller DAG, 
 * which is the same problem. This will then give our BFS solution.
 * Topological Sorting using BFS
 * Time Complexity: O(V+E)
 * Space Complexity: O(V)
 *
 */
class Order{
    String orderName;
    public Order(String orderName)
    {
        this.orderName = orderName;
    }
}
class OrderDependency{
    Order cur;
    Order pre;
    public OrderDependency(Order cur, Order pre)
    {
        this.cur = cur;
        this.pre = pre;
    }
}
public class OrderDependencyTPS {
    public static List<Order> findOrder(List<OrderDependency> depenency)
    {
        Map<String, Integer> indegree = new HashMap<>();
        Map<String, List<String>> outmap = new HashMap<>();
        List<Order> res = new ArrayList<>();
        
        // convert the edge list to adjacent lists and calculate the indegree
        for(OrderDependency i: depenency)
        {
        	// keep the start point
            if(!indegree.containsKey(i.pre.orderName)) 
            	indegree.put(i.pre.orderName, 0);
            
            if(!indegree.containsKey(i.cur.orderName)) 
            	indegree.put(i.cur.orderName, 0);          
            indegree.put(i.cur.orderName, indegree.get(i.cur.orderName) + 1);
            
            if(!outmap.containsKey(i.pre.orderName)) 
            	outmap.put(i.pre.orderName, new ArrayList<String>());          
            outmap.get(i.pre.orderName).add(i.cur.orderName);
        }
        
        // BFS, find the start point
        Queue<String> queue = new LinkedList<>();
        for(String i: indegree.keySet())
        {
        	// Add to result list if no incoming edges
            if(indegree.get(i) == 0) queue.offer(i);
        }
        while(!queue.isEmpty())
        {
            String s = queue.poll();
            
            // add to result list
            res.add(new Order(s));
            if(outmap.containsKey(s))
            {
                for(String o: outmap.get(s))
                {
                	// Remove this incoming edge
                	indegree.put(o, indegree.get(o) - 1);
                    if(indegree.get(o) == 0) 
                    	// Add to queue if no incoming edges
                    	queue.offer(o);
                }
            }
            outmap.remove(s);
        }
        return res;
    }
    public static void main(String[] args)
    {
        List<OrderDependency> input = new ArrayList<>();
        input.add(new OrderDependency(new Order("A"), new Order("E")));
        input.add(new OrderDependency(new Order("D"), new Order("E")));
        input.add(new OrderDependency(new Order("A"), new Order("C")));
        input.add(new OrderDependency(new Order("B"), new Order("D")));
        List<Order> output = findOrder(input);
        for(Order i: output) System.out.print(i.orderName + " ");
    }
}
