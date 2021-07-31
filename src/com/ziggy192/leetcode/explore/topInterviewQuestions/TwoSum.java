package com.ziggy192.leetcode.explore.topInterviewQuestions;

import java.util.*;

/**
 * Remove Duplicates from Sorted Array
 */
public class TwoSum{
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		List<Integer> l = new ArrayList<>();
		l.toArray(new Integer[0]);
		System.out.println(Arrays.toString(new Solution().twoSum(new int[]{3,2,4}, 6)));
	}

	static class Solution {
		public int[] twoSum(int[] nums, int target) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i<nums.length; i++){
				map.put(nums[i],i);
			}

			for (int i =0; i<nums.length; i++){
				if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i ) {
					return new int[]{i,map.get(target - nums[i])};
				}
			}
			assert false;
			return null;
		}
	}
}
