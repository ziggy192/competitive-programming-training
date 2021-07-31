package com.ziggy192.interviews.ninjavan.test;

import java.util.Arrays;

public class Example2 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(rotLeft(new int[]{1, 2, 3, 4, 5}, 4)));
	}
	static int[] rotLeft(int[] a, int d) {
		int[] res = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			res[i] = a[query(i, d, a.length)];
		}
		return res;

	}

	static int query(int i, int k, int n) {
		int r = i - k;
		return mod(r, n);
	}

	static int mod(int x, int y) {
		int r = Math.abs(x) % Math.abs(y);
		r *= Math.signum(x);
		return (r + Math.abs(y)) % Math.abs(y);
	}
}
