package com.ziggy192.leetcode;

import javafx.util.Pair;

import java.security.KeyPair;
import java.util.*;

public class SwapForLongestRepeatedCharacterSubstring {
	public int maxRepOpt1(String text) {
		List<int[]> a = new ArrayList<>();
		a.add(new int[]{2,1});
		System.out.println(Arrays.toString(a.get(0)));
		Pair<Integer, Integer> p = new Pair<>(1,1);
		Deque<Integer> deque = new ArrayDeque<>();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		return 0;
	}

	public static void main(String[] args) {
		new SwapForLongestRepeatedCharacterSubstring().maxRepOpt1("");
	}
}
