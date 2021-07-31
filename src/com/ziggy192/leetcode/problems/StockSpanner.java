package com.ziggy192.leetcode.problems;

import java.util.*;

public class StockSpanner {
	Deque<Integer> d;
	List<Integer> l;
	public StockSpanner() {
		d  = new ArrayDeque<>();
		l = new ArrayList<>();
	}

	public int next(int price) {
		l.add(price);
		int cur = l.size()-1;
		while (!d.isEmpty() && l.get(d.peekLast()) <= price ){
			
			d.pollLast();
		}
		int last;
		if (!d.isEmpty()) {
			last = d.peekLast();
		}else{
			last = -1;
		}
		d.offerLast(cur);

		return cur - last;
	}

	public static void main(String[] args) {
		final StockSpanner stockSpanner = new StockSpanner();
		int[] a = new int[]{100,80,60,70,60,75,85};
		for (int i : a) {
			System.out.println(stockSpanner.next(i));
		}
	}
}
