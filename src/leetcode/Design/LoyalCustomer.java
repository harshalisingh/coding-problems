package leetcode.Design;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LoyalCustomer {
	/**
	   *
	   * @param d - number of consecutive days
	   * @param log - list of lines from the log file
	   * @param separator - separator between the date and id
	   * @return - set of loyal customers who logs in {@code d} consecutive days
	   */
	  static Set<String> getLoyalCustomers(int d, String[] log, String separator) {
	    Set<String> loyalCustomers = new HashSet<>();
	    Map<String, LinkedList<String>> cache = new HashMap<>();
	    for (String line : log) {
	      String[] details = line.split(separator);
	      String day = details[0];
	      String id = details[1];
	      // to check if the customer is already a loyal one
	      if (loyalCustomers.contains(id)) {
	        continue;
	      }
	      // to check if the customer is in cache already
	      if (!cache.containsKey(id)) {
	        cache.put(id, new LinkedList<>());
	        cache.get(id).add(day);
	      } else {
	        // to check if the day and last logged day is the consecutive days.
	        if (isItTwoConsecutiveDays(cache.get(id).getLast(), day)) {
	          if (cache.get(id).size() == d - 1) {
	            loyalCustomers.add(id);
	            cache.remove(id);
	          } else {
	            cache.get(id).add(day);
	          }
	        } else {
	          cache.get(id).clear();
	          cache.get(id).add(day);
	        }
	      }
	    }
	    return loyalCustomers;
	  }

	  /**
	   *
	   * @param day1 - day in format MM/dd/yyyy
	   * @param day2 - day in format MM/dd/yyyy
	   * @return - true if day2 is follow by day1, otherwise false
	   */
	  private static boolean isItTwoConsecutiveDays(String day1, String day2) {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	    LocalDate dayOne = LocalDate.parse(day1, formatter);
	    LocalDate dayTwo = LocalDate.parse(day2, formatter);
	    return dayOne.plusDays(1).isEqual(dayTwo);
	  }
}
