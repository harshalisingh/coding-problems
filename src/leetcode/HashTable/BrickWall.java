package leetcode.HashTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. 
 * The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.
 * https://leetcode.com/problems/brick-wall/#/description
 */
public class BrickWall {
	public int leastBricks(List<List<Integer>> wall) {
        if(wall.size() == 0) return 0;
        int count = 0;
        
        //HashMap stores the frequency of edges at different locations. 
        //The location with largest number of edges will have a vertical line cross the least number of bricks.
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(List<Integer> list : wall){
            int length = 0;
            for(int i = 0; i < list.size() - 1; i++){
                length += list.get(i);
                map.put(length, map.getOrDefault(length, 0) + 1);
                
                //count = max count of edges at a particular location
                count = Math.max(count, map.get(length));
            }
        }
        
        //subtract total number of rows with max count of edges at a location
        return wall.size() - count;
    }
}
