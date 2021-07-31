package com.ziggy192.leetcode.problems;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * <p>
 * Examples:
 * <p>
 * s = "leetcode"
 * return 0.
 * <p>
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterInString {
	public static void main(String[] args) {
		System.out.println(firstUniqChar("leetcode"));
	}

	public static int firstUniqChar(String s) {
		Map<Character, Item> m = new HashMap<>();
		char[] cs = s.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (m.containsKey(cs[i])) {
				Item item = m.get(cs[i]);
				item.count += 1;
				m.put(cs[i], item);
			} else {
				Item item = new Item(i);
				m.put(cs[i], item);
			}
		}

		int min = cs.length;
		for (Item item : m.values()) {
			if (item.count == 1 && item.index < min) {
				min = item.index;
			}
		}
		if (min == cs.length) return -1;
		return min;

	}

	static class Item {
		int index;
		int count;

		Item(int index) {
			this.index = index;
			count = 1;
		}
	}
}
