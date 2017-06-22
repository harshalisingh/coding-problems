package leetcode.Backtracking;

public class PrintAllCoinChangeCombination {
	public static void main(String[] args) {  
        int[] coins = {25, 10, 5, 1};  
        int[] counts = new int[coins.length];  
        System.out.println("All possible coin combinations of 10 cents are: ");  
        printCombination(coins, counts, 0, 10);  
  
        System.out.println("All possible coin combinations of 25 cents are: ");  
        printCombination(coins, counts, 0, 25);  
    }  
  
    // coins are the sorted coins in descending order, larger positioned more front  
    // counts record the number of coins at certain location  
    // start index is keep cracking of from which coin we start processing after choosing one larger coin amount  
    // total amount keep track of remaining amount left processing  
    private static void printCombination(int[] coins, int[] counts, int startIndex, int totalAmount) {  
        if (startIndex >= coins.length) {  
            // format the print out as "amount=?*25 + ?*10 + ..."  
            for (int i = 0; i < coins.length; i++) {  
                System.out.print("" + counts[i] + " * " + coins[i] + " + ");  
            }   
            System.out.println();   
            return;  
        }  
        // notice if startIndex is the last one, we need check if it can be dividable by the smallest coin  
        // if so, this is a good combination, otherwise, this is not possible combination thus discarded  
        if (startIndex == coins.length - 1) {  
            if (totalAmount % coins[startIndex] == 0) { // good combination  
                // set the counts of coins at start index  
                counts[startIndex] = totalAmount / coins[startIndex];  
                // proceed to recursive call  
                printCombination(coins, counts, startIndex + 1, 0); // notice startIndex + 1 and remaining amount = 0  
            }  
        } else {    // we still have option to choose 0-N larger coins  
            for (int i = 0; i <= totalAmount / coins[startIndex]; i++) {  
                // for every cycle in a loop, we choose an arbitrary number of larger coins and proceed next  
                counts[startIndex] = i;  
                // notice we need to update the remaining amount  
                printCombination(coins, counts, startIndex + 1, totalAmount - coins[startIndex] * i);  
            }  
        }  
    }  
}
