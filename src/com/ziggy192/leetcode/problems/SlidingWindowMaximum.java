package com.ziggy192.leetcode.problems;

import java.util.*;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 *
 * Follow up:
 * Could you solve it in linear time?
 *
 * Example:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 */
public class SlidingWindowMaximum {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution().maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3)));
	}
	static class Solution {
		public int[] maxSlidingWindow(int[] nums, int k) {
			Deque<Integer> d = new ArrayDeque<>();
			List<Integer> l = new ArrayList<>();
			for (int i = 0; i < nums.length; i++){
				while (!d.isEmpty() && d.peek() < i-k+1){
					d.poll();
				}
				while (!d.isEmpty() && nums[d.peekLast()] < nums[i]){
					d.pollLast();
				}
				d.add(i);
				if (i >=k-1)           l.add(nums[d.peek()]);
				Map<Character,Integer> m;
				Stack<Integer> s = new Stack<>();
			}
			return l.stream().mapToInt(i -> i).toArray();
		}
	}
}
