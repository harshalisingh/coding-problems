package leetcode.contest;

import java.util.HashMap;
import java.util.Map;

public class LonelyPixelII {
	/*
	 * Scan each row. If that row has N black pixels, put a string signature, 
	 * which is concatenation of each characters in that row, as key and how many times we see that signature into a HashMap. 
	 * Go through the HashMap and if the count of one signature is N, those rows potentially contain black pixels we are looking for. 
	 * Then we validate each of those columns. For each column of them has N black pixels (lookup in colCount array), we get N valid black pixels.
	 */
	public int findBlackPixel(char[][] picture, int N) {
        if (picture == null || picture.length == 0 || picture[0].length == 0) return 0;
        int m = picture.length, n = picture[0].length;
        int[] cols = new int[n];
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < m; i++) {
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    cols[j]++;
                    count++;
                }
                sb.append(picture[i][j]);
            }
            if (count == N) {
                String curRow = sb.toString();
                map.put(curRow, map.getOrDefault(curRow, 0) + 1);
            }
        }
        
        int res = 0;
        for (String row : map.keySet()) {
            if (map.get(row) != N) continue;
            for (int i = 0; i < n; i++) {
                if (row.charAt(i) == 'B' && cols[i] == N) {
                    res += N;
                }
            }
        }
        return res;
    }
}
