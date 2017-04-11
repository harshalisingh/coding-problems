package oa;

import java.util.*;

public class WindowSum {
	public List<Integer> calculate(List<Integer> list, int window) {
		List<Integer> res = new ArrayList<>();
		if (list == null || list.size() == 0 || window <= 0) {
			return res;
		}
		int sum = 0;
		for (int i = 0; i < window && i < list.size(); i++) {
			sum += list.get(i);
		}
		res.add(sum);
		if (list.size() <= window) {
			return res;
		}
		for (int i = window; i < list.size(); i++) {
			sum = sum - list.get(i - window) + list.get(i);
			res.add(sum);
		}
		return res;
	}

	public static void main(String[] args) {
		WindowSum test = new WindowSum();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		List<Integer> res = test.calculate(list, 3);
		for (Integer i: res) {
			System.out.print(i + ",");
		}
		System.out.println();
	}
}

