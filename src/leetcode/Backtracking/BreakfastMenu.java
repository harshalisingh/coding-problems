package leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

/** Find the number of ways you can have breakfast in 'n' days, 
 * given Bread-butter can be eaten every day, 
 * Pizza can be eaten every alternate day and Burger can be eaten every two days. 
 */
public class BreakfastMenu {
	public List<List<String>> breakfastMenuWays(String[] menu, int numDays){
		List<List<String>> list = new ArrayList<>();
		backtrack(menu, 0, numDays, new ArrayList<String>(), list);
		return list;
		
	}

	private void backtrack(String[] menu, int startDay, int numDays, ArrayList<String> tempList, List<List<String>> list) {
		// TODO Auto-generated method stub
		if(tempList.size() == numDays){
			list.add(new ArrayList<>(tempList));
		} else {
			for(int i = 0; i < menu.length; i++){
				if(isValidMenu(tempList, startDay, numDays, menu[i])){
					tempList.add(menu[i]);
					backtrack(menu, startDay + 1, numDays, tempList, list);
					tempList.remove(tempList.size() - 1);
				}
				
			}
		}
	}

	private boolean isValidMenu(ArrayList<String> tempList, int day, int numDays, String todayMenu) {
		int prevDay = day-1;
		int prev2Day = day-2;
		if(prevDay > -1 && tempList.get(prevDay).equals("pizza") && todayMenu.equals("pizza")){
			return false;
		}
		if(prev2Day > -1 && tempList.get(prev2Day).equals("burger") && todayMenu.equals("burger")){
			return false;
		}
		return true;
	}
	
	int countBreakfastMenuWays(String[] menu, int numDays){
		return rec(0, numDays, "", "");
	}
	
	int rec(int c, int n, String f1, String f2){
		if(n == 0) return 0;
		c = 1 + rec(c, n-1, "bread", f1);
		if(!f1.equals("pizza")) c += 1 + rec(c, n-1, "pizza", f1);
		if(!f2.equals("burger") && !f1.equals("burger")) c += 1 + rec(c, n-1, "burger", f1);
		return c;
	}
	
	public static void main(String[] args){
		BreakfastMenu bfm = new BreakfastMenu();
		String[] menu = new String[]{"bread", "pizza", "burger"};
		for(List<String> menuList: bfm.breakfastMenuWays(menu, 2)){
			System.out.println(menuList.toString());
		}
		
		System.out.println(bfm.countBreakfastMenuWays(menu, 2));
	}
}
