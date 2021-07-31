package com.ziggy192.leetcode.problems;

import javafx.util.Pair;

import java.util.*;

public class UniquePath {
	public static void main(String[] args) {
		System.out.println(new Solution().uniquePaths(3, 3));

	}

	static class Solution {
		public int uniquePaths(int m, int n) {
			int[][] l = new int[m][n];
			Arrays.fill(l[0], 0);
			Arrays.setAll(l,value -> Arrays.copyOf(l[0], l[0].length));
			l[0][0] = 1;
			for (int[] ints : l) {
				System.out.println(Arrays.toString(ints));
			}
			List<Pair<Integer, Integer>> q = new ArrayList<>();
			q.add(new Pair<>(0, 0));
			while (!q.isEmpty()) {
				List<Pair<Integer, Integer>> k = new ArrayList<>();
				for (Pair<Integer, Integer> p : q) {
					int x = p.getKey();
					int y = p.getValue();
					check(x + 1, y, l[x][y], k, l, m, n);
					check(x, y + 1, l[x][y], k, l, m, n);
				}

				q = k;
			}
			Set<Integer> set  = new HashSet<>();
			set.stream().toArray();
			Collections.addAll(set, 2,1);
			return l[m - 1][n - 1];
		}

		private void check(int x, int y, int val, List<Pair<Integer, Integer>> k, int[][] l, int m, int n) {
			if (!(x < m && y < n)) {
				return;
			}
			if (l[x][y] == 0) {
				k.add(new Pair<>(x, y));
			}
			l[x][y] = l[x][y] + val;
		}
	}
}
