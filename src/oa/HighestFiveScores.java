package oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Given a list of test results (each with a test date, Student ID, and the student’s Score), return the Final Score for each student. 
 * A student’s Final Score is calculated as the average of his/her 5 highest test scores.
 * You can assume each student has at least 5 test scores.
 * 
 * You may use the JDK or the standard template library. The solution will be evaluated on correctness, runtime complexity (big-O), 
 * and adherence to coding best practices. 
 * A complete answer will include the following:

	Document your assumptions
	Explain your approach and how you intend to solve the problem
	Provide code comments where applicable
	Explain the big-O run time complexity of your solution. Justify your answer.
	Identify any additional data structures you used and justify why you used them.
	Only provide your best answer to each part of the question.
 */

/**
 * Complexity : O(klogn) , k =5 ==> O(logn). And O(n+m) , in general = O(max(n,m) . In your case its O(n).
 *
 */
class TestResult{
	int studentId;
	int testScore;
	public TestResult(int studentId, int testScore){
		this.studentId = studentId;
		this.testScore = testScore;
	}
}

public class HighestFiveScores {
	public static Map<Integer, Double> getFinalScores(List<TestResult> results){
		if(results == null || results.size() == 0) {
			return new HashMap<>();
		}

		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
		for(TestResult res: results)
		{
			if(!map.containsKey(res.studentId))
			{
				map.put(res.studentId, new PriorityQueue<Integer>());
				map.get(res.studentId).offer(res.testScore);
			}
			else
			{
				if(map.get(res.studentId).size() < 5) 
					map.get(res.studentId).offer(res.testScore);

				else if(res.testScore > map.get(res.studentId).peek())
				{
					map.get(res.studentId).poll();
					map.get(res.studentId).offer(res.testScore);
				}
			}
		}
		Map<Integer, Double> highestFiveAverage = new HashMap<>();
		for(int id: map.keySet())
		{
			double sum = 0;
			PriorityQueue<Integer> q = map.get(id);
			while(!q.isEmpty()) sum += q.poll();
			highestFiveAverage.put(id, sum / 5.0);
		}
		return highestFiveAverage;
	}

	public static void main(String[] args) {
		TestResult r1 = new TestResult(1, 95);
		TestResult r2 = new TestResult(1, 95);
		TestResult r3 = new TestResult(1, 91);
		TestResult r4 = new TestResult(1, 91);
		TestResult r5 = new TestResult(1, 93);
		TestResult r6 = new TestResult(1, 105);

		TestResult r7 = new TestResult(2, 6);
		TestResult r8 = new TestResult(2, 6);
		TestResult r9 = new TestResult(2, 7);
		TestResult r10 = new TestResult(2, 6);
		TestResult r11 = new TestResult(2, 6);
		TestResult[] arr = {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
		Map<Integer, Double> res = getFinalScores(Arrays.asList(arr));

		System.out.println(res.get(1) + " " +res.get(2));
	}
}
