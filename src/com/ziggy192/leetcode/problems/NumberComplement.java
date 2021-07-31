package com.ziggy192.leetcode.problems;

public class NumberComplement {
	public static void main(String[] args) {
		System.out.println(new Solution().findComplement(5));
	}
	static class Solution {
		public int findComplement(int num) {
			int k = num;
			int l = 0;
			while (k > 0){
				k = k >>> 1;
				if (l == 0) {
					l = 1;
				}else {
					l = l << 1;
				}
			}
			return num ^ l;
		}
	}
}
