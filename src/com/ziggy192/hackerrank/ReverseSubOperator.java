package com.ziggy192.hackerrank;

import java.util.List;

public class ReverseSubOperator {
	public static List<Integer> performOperations(List<Integer> arr, List<List<Integer>> operations) {
		for (List<Integer> op : operations) {
			int left = op.get(0);
			int right = op.get(1);
			// reverse left -> right
			while (left <= right) {
				int temp = arr.get(left);
				arr.set(left, arr.get(right));
				arr.set(right, temp);
				left++;
				right--;
			}
		}
		return arr;
	}
}
