package leetcode.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/flip-game/#/description
 * https://leetcode.com/problems/flip-game-ii/#/description
 */
public class FlipGame {
	public List<String> generatePossibleNextMoves(String s) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.startsWith("++", i)) {
				String t = s.substring(0, i) + "--" + s.substring(i + 2);
				list.add(t);
			}
		}
		return list;
	}


	/* Backtracking
	 * T(N) = (N-2) * T(N-2) = (N-2) * (N-4) * T(N-4) ... = (N-2) * (N-4) * (N-6) * ... ~ O(N!!)
	 */
	public boolean canWin(String s) {
		if (s == null || s.length() < 2) {
			return false;
		}
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.startsWith("++", i)) {
				String opponent = s.substring(0, i) + "--" + s.substring(i + 2);
				if (!canWin(opponent)) {
					return true;
				}
			}
		}
		return false;
	}

	/* Backtracking + Memoization (use HashMap to memorize both win string & lose string)
	 * O(2^n)
	 * Key : InputString, Value: can win or not.
	 */
	public boolean canWinMemoziation(String s) {
		if(s == null || s.length() < 2) return false;
		Map<String, Boolean> map = new HashMap<>();
		return canWin(s, map);
	}

	public boolean canWin(String s, Map<String, Boolean> map){
		if(map.containsKey(s)) return map.get(s);
		for(int i = 0; i < s.length() - 1; i++) {
			if (s.startsWith("++", i)) { //if(s.charAt(i) == '+' && s.charAt(i + 1) == '+')
				String opponent = s.substring(0, i) + "--" + s.substring(i + 2);
				if(!canWin(opponent, map)) {
					map.put(s, true);
					return true;
				}
			}
		}
		map.put(s, false);
		return false;
	}
}
