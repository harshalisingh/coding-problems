package leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStrings {
	public List<String> generateBinaryStrings(int n){
		List<String> result = new ArrayList<>();
		backtrack(result, new StringBuilder(), n);
		return result;
	}
	
	private void backtrack(List<String> res, StringBuilder sb, int digitsLeft){
		if(digitsLeft == 0){
			res.add(sb.toString());
		} else {
			backtrack(res, sb.append("0"), digitsLeft - 1);
			sb.setLength(sb.length() - 1);
			backtrack(res, sb.append("1"), digitsLeft - 1);
			sb.setLength(sb.length() - 1);
		}
	}
	
	public static void main(String[] args){
		GenerateBinaryStrings caller = new GenerateBinaryStrings();
		for(String s : caller.generateBinaryStrings(3)){
			System.out.println(s);
		}
	}
}
