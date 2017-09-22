package leetcode.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two arrays, write a function to compute their intersection.
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 */
public class IntersectionTwoArraysII {
	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i < nums1.length; i++){
			map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
		}

		for(int i = 0; i < nums2.length; i++)
		{
			if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0)
			{
				result.add(nums2[i]);
				map.put(nums2[i], map.get(nums2[i])-1);
			}
		}

		int[] r = new int[result.size()];
		for(int i = 0; i < result.size(); i++)
		{
			r[i] = result.get(i);
		}
		return r;
	}
}
