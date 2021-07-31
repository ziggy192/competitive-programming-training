package com.ziggy192.leetcode.explore.topInterviewQuestions;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {
	private Random random;
	private int[] nums;

	public ShuffleAnArray(int[] nums) {
		random = new Random();
		this.nums = nums;
	}

	/**
	 * Resets the array to its original configuration and return it.
	 */
	public int[] reset() {
		return nums;
	}

	/**
	 * Returns a random shuffling of the array.
	 */
	public int[] shuffle() {
		int[] res = Arrays.copyOf(nums, nums.length);
		for (int i = 0; i < res.length; i++) {
			swap(res, i, i + random.nextInt(res.length - i));
		}
		
		return res;

	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
