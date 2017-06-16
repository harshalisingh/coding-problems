package leetcode.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/find-duplicate-file-in-system/#/description
 * Time complexity : O(n*x). n strings of average length x is parsed.
 * Space complexity : O(n*x). map and result size grows upto n*x.
 */
public class FindDuplicateFiles {
	public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<>();
        int n = paths.length;
        if (n == 0) return result;
        
        Map<String, Set<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] strs = path.split("\\s+");
            for (int i = 1; i < strs.length; i++) {
                int idx = strs[i].indexOf("(");
                String content = strs[i].substring(idx);
                String filename = strs[0] + "/" + strs[i].substring(0, idx);
                Set<String> filenames = map.getOrDefault(content, new HashSet<String>());
                filenames.add(filename);
                map.put(content, filenames);
            }
        }
        
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                result.add(new ArrayList<String>(map.get(key)));
            }
        }
        
        return result;
    }
}
