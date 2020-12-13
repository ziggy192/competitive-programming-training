package com.ziggy192.utils;

import java.util.function.BiFunction;

public class SegmentTree {
	Node root;

	public SegmentTree(int[] a, BiFunction<Integer, Integer, Integer> f) {
		this.root = new Node(0, a.length - 1, a, f);
	}

	int search(int from, int to) {
		return root.search(from, to);
	}

	static class Node {
		int from;
		int to;
		int val;
		BiFunction<Integer, Integer, Integer> f;
		Node left;
		Node right;

		public Node(int from, int to, int[] a, BiFunction<Integer, Integer, Integer> f) {
			this.from = from;
			this.to = to;
			this.f = f;
			if (from == to) {
				this.val = a[from];
				left = null;
				right = null;
			} else {
				int m = (from + to) / 2;
				this.left = new Node(from, m, a, f);
				this.right = new Node(m + 1, to, a, f);
				this.val = f.apply(left.val, right.val);
			}
		}

		public int search(int from, int to) {
			if (this.from <= from && to <= this.to) {
				return this.val;
			}
			int m = (this.from + this.to) / 2;
			if (to <= m) {
				return this.left.search(from, to);
			}
			if (from >= m + 1) {
				return this.right.search(from, to);
			}
			// from <=m && to >= m+1
			return f.apply(this.left.search(from, m), this.right.search(m + 1, to));
		}
	}
}
