package leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

/* Given a string that contains only digits 0-9 and a target value, 
 * return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
 * https://leetcode.com/problems/expression-add-operators/#/description
 */
public class ExpressionAddOperators {
	public List<String> addOperators(String num, int target) {
		List<String> res = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		dfs(res, sb, num, 0, target, 0, 0);
		return res;

	}
	public void dfs(List<String> res, StringBuilder sb, String num, int pos, int target, long prev, long multi) { 
		if(pos == num.length()) {
			//System.out.println(sb.toString());
			if(target == prev) res.add(sb.toString());
			return;
		}
		for(int i = pos; i < num.length(); i++) {
			if(num.charAt(pos) == '0' && i != pos) break;
			long curr = Long.parseLong(num.substring(pos, i + 1));
			int len = sb.length();
			if(pos == 0) {
				dfs(res, sb.append(curr), num, i + 1, target, curr, curr); 
				sb.setLength(len);
			} else {
				dfs(res, sb.append("+").append(curr), num, i + 1, target, prev + curr, curr); 
				sb.setLength(len);
				dfs(res, sb.append("-").append(curr), num, i + 1, target, prev - curr, -curr); 
				sb.setLength(len);
				dfs(res, sb.append("*").append(curr), num, i + 1, target, prev - multi + multi * curr, multi * curr); 
				sb.setLength(len);
			}
		}
	}
	
	public static void main(String[] args){
		ExpressionAddOperators ea = new ExpressionAddOperators();
		List<String> res = ea.addOperators("105", 5);
	}
}

class AddOperators {
	public List<String> addOperators(String num, int target) {
		List<String> rst = new ArrayList<String>();
		if(num == null || num.length() == 0) return rst;
		helper(rst, "", num, target, 0, 0, 0);
		return rst;
	}
	public void helper(List<String> rst, String path, String num, int target, int pos, long prev, long multed){
		if(pos == num.length()){
			if(target == prev)
				rst.add(path);
			return;
		}
		for(int i = pos; i < num.length(); i++){
			if(i != pos && num.charAt(pos) == '0') break;
			long cur = Long.parseLong(num.substring(pos, i + 1));
			if(pos == 0){
				helper(rst, path + cur, num, target, i + 1, cur, cur);
			}
			else{
				helper(rst, path + "+" + cur, num, target, i + 1, prev + cur , cur);

				helper(rst, path + "-" + cur, num, target, i + 1, prev -cur, -cur);

				/* if you have a sequence of 12345 and you have proceeded to 1 + 2 + 3, now your eval is 6 right? 
				 * If you want to add a * between 3 and 4, you would take 3 as the digit to be multiplied, 
				 * so you want to take it out from the existing eval. You have 1 + 2 + 3 * 4 and the eval now is (1 + 2 + 3) - 3 + (3 * 4).
				 */
				helper(rst, path + "*" + cur, num, target, i + 1, prev - multed + multed * cur, multed * cur );
			}
		}
	}
}
