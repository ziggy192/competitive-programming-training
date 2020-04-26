package com.ziggy192.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Remove Duplicates from Sorted Array
 */
public class TwoSum{
	public static void main(String[] args) {
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
