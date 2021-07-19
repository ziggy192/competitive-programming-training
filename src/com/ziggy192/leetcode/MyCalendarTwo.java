package com.ziggy192.leetcode;

import java.util.TreeMap;

public class MyCalendarTwo {
	TreeMap<Integer, Integer> delta;
	public MyCalendarTwo() {
		delta = new TreeMap<>();
	}

	public boolean book(int start, int end) {
		delta.put(start, delta.getOrDefault(start, 0) + 1);
		delta.put(end, delta.getOrDefault(end, 0) - 1);
		int active = 0;
		for (Integer value : delta.values()) {
			active += value;
			if (active >= 3) {
				// false
				delta.put(start, delta.get(start) - 1);
				delta.put(end, delta.get(end) + 1);
				return false;
			}
		}
		return true;
	}

}
