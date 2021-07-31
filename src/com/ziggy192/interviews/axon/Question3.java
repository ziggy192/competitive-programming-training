package com.ziggy192.interviews.axon;

import java.util.HashMap;
import java.util.Map;

public class Question3 {
	public static void main(String[] args) {
		System.out.println(solution(new long[]{123, 1}, 124));
	}
	public static boolean solution(long[] numbers, long target) {
		// Type your solution here]

		return new Question3().sol(numbers,target);
	}

	private boolean sol(long[] numbers, long target) {
		Map<Long,Integer> map = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			map.put(numbers[i], i);
		}
		for (int i = 0; i < numbers.length; i++) {
			long val = target - numbers[i];
			if (map.containsKey(val) && map.get(val) != i) {
				return true;
			}

		}
		return false;

	}


}
