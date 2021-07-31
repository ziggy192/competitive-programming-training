package com.ziggy192.interviews.ninjavan.test;

import java.util.Arrays;

public class Example {
	public static void main(String[] args) {
		int[] a = new int[]{1, 2, 3};
		int k = 2;
		int[] q = new int[]{0, 1, 2};

		System.out.println(Arrays.toString(circularArrayRotation(a, k, q)));
	}
	static int[] circularArrayRotation(int[] a, int k, int[] queries) {
		int[] res = new int[queries.length];
		for (int i = 0 ; i < queries.length; i++){
			res[i] = a[query(queries[i],k,a.length)];
		}
		return res;

	}
	static int query(int i, int k, int n ){
		int res = i - k;
		return euclideanMod(res, n);
	}
	static int euclideanMod(int x, int y) {
		int r = Math.abs(x) % Math.abs(y);
		r *= Math.signum(x);
		return (r + Math.abs(y)) % Math.abs(y);
	}

}
