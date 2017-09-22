package leetcode.Design;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LogStorageSystem {

	List<String[]> timestamps;
	Map<String, Integer> unitIdxMap;
	public LogStorageSystem() {
		timestamps = new LinkedList<>();
        unitIdxMap = new HashMap<>();
        // init
        unitIdxMap.put("Year", 4);
        unitIdxMap.put("Month", 7);
        unitIdxMap.put("Day", 10);
        unitIdxMap.put("Hour", 13);
        unitIdxMap.put("Minute", 16);
        unitIdxMap.put("Second", 19);
    }
    

	public void put(int id, String timestamp) { timestamps.add(new String[]{Integer.toString(id), timestamp}); }

	public List<Integer> retrieve(String s, String e, String gra) {
		List<Integer> res = new LinkedList<>();
		int idx = unitIdxMap.get(gra);
		for (String[] timestamp : timestamps) {
			if (timestamp[1].substring(0, idx).compareTo(s.substring(0, idx)) >= 0 &&
					timestamp[1].substring(0, idx).compareTo(e.substring(0, idx)) <= 0) res.add(Integer.parseInt(timestamp[0]));
		}
		return res;
	}
	
	public static void main(String[] args){
		LogStorageSystem obj = new LogStorageSystem();
		obj.put(1, "2017:01:01:23:59:59");
		obj.put(2, "2017:01:01:22:59:59");
		obj.put(3, "2016:01:01:00:00:00");
		List<Integer> param_2 = obj.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year");
		System.out.println(param_2.toString());
		
		List<Integer> param_3 = obj.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour");
		System.out.println(param_3.toString());
		
	}
}
