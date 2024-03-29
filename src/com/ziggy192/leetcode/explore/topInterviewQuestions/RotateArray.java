package com.ziggy192.leetcode.explore.topInterviewQuestions;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * <p>
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 * <p>
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class RotateArray {
	public static void main(String[] args) {

	}

	static class Solution {

		public void rotate(int[] nums, int k) {
			k = k % nums.length;
			reverse(nums,0,nums.length);
			reverse(nums,0,k);
			reverse(nums, k , nums.length);
		}

		private void reverse(int[] a, int from, int to) {
			int i = from;
			int j = to - 1;
			while (i < j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}

	}
}
