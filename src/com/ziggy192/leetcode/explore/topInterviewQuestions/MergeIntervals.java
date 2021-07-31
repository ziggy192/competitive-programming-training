package com.ziggy192.leetcode.explore.topInterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {
	static class Item implements Comparable<Item> {
		int val;
		boolean open;
		Item(int val, boolean open){
			this.val= val;
			this.open = open;
		}
		public int compareTo(Item i){
			if (this.val == i.val){
				int v1 = boolval(this.open);
				int v2 = boolval(i.open);
				return v1 - v2;
			}
			return this.val - i.val;
		}
		static int boolval(boolean v){
			if (v) return -1;
			return 1;
		}
	}


	public int[][] merge(int[][] intervals) {
		List<Item> l = new ArrayList<>();
		for (int[] interval : intervals){
			l.add(new Item(interval[0],true));
			l.add(new Item(interval[1],false));
		}
		Collections.sort(l);
		List<List<Integer>> res = new ArrayList<>();
		int s = 0;
		Integer start = null;
		Integer end = null;
		for (Item i : l){
			if (i.open) {
				s++;
				if (start == null ) start = i.val;
			}
			else s--;
			if (s ==0 ){
				// add to res
				end = i.val;
				List<Integer> k = Arrays.asList(start,end);
				res.add(k);
				start = null;
			}
		}

		return toArray(res);


	}

	private int[][] toArray(List<List<Integer>> l ){
		int[][] res = new int[l.size()][];
		for (int i = 0; i < res.length; i++){
			res[i] = l.get(i).stream().mapToInt(it->it).toArray();;
		}
		return res;
	}
}
