package oa;

import java.util.*;


/**
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
        Map<String, Integer> inmap = new HashMap<>();
        Map<String, List<String>> outmap = new HashMap<>();
        List<Order> res = new ArrayList<>();
        
        // convert the edge list to adjacent lists and calculate the indegree
        for(OrderDependency i: depenency)
        {
        	// keep the start point
            if(!inmap.containsKey(i.pre.orderName)) 
            	inmap.put(i.pre.orderName, 0);
            
            if(!inmap.containsKey(i.cur.orderName)) 
            	inmap.put(i.cur.orderName, 0);          
            inmap.put(i.cur.orderName, inmap.get(i.cur.orderName) + 1);
            
            if(!outmap.containsKey(i.pre.orderName)) 
            	outmap.put(i.pre.orderName, new ArrayList<String>());          
            outmap.get(i.pre.orderName).add(i.cur.orderName);
        }
        
        // BFS, find the start point
        Queue<String> queue = new LinkedList<>();
        for(String i: inmap.keySet())
        {
        	// Add to result list if no incoming edges
            if(inmap.get(i) == 0) queue.offer(i);
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
                    inmap.put(o, inmap.get(o) - 1);
                    if(inmap.get(o) == 0) 
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
