package com.ziggy192.interviews.axon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Question1 {
	public static void main(String[] args) {
		System.out.println(solution("akhidhadbk"));
	}

	public static long solution(String s) {

		return new Question1().sol(s);
	}

	private long sol(String s) {
		Deque<Character> deque = new ArrayDeque<>();
		final char[] chars = s.toCharArray();
		Set<Character> set = new HashSet<>();
		long max = 0;
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (set.contains(c)) {
				Character first;
				do {
					first = deque.pollFirst();
					set.remove(first);
				} while (first != null && !first.equals(c));
			}
			deque.addLast(c);
			set.add(c);
			if (deque.size() > max) max = deque.size();

		}
		return max;
	}
}
