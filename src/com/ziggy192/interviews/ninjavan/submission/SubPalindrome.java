package com.ziggy192.interviews.ninjavan.submission;

import java.util.HashSet;
import java.util.Set;

public class SubPalindrome {
	public static void main(String[] args) {
		System.out.println(palindrome("aabaa"));
	}

	public static int palindrome(String s) {
		char[] a = s.toCharArray();
		Set<String> set = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			checkOdd(set,a, i);
			if (i < a.length - 1) {
				checkEven(set,a, i, i + 1);
			}
		}
		return set.size();
	}

	private static void checkEven(Set<String> set, char[] a, int l, int r) {
		check(set,a, l, r);
	}

	static void checkOdd(Set<String> set, char[] a, int i) {
		check(set, a, i, i);
	}

	private static void check(Set<String> set, char[] a, int l, int r) {
		StringBuilder sb = new StringBuilder("");
		while (l >= 0 && r < a.length && a[l] == a[r]) {
			// add to set
			if (l == r) {
				sb.append(a[l]);
			} else {
				sb.insert(0, a[l]);
				sb.append(a[r]);
			}
			set.add(sb.toString());
			l--;
			r++;
		}
	}

}
