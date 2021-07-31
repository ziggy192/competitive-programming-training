package com.ziggy192.leetcode.problems;

import java.util.Scanner;

/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 * Example:
 *
 * Given n = 5, and version = 4 is the first bad version.
 *
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 *
 * Then 4 is the first bad version.
 */
public class FirstBadVersion {

	public static void main(String[] args) {
		int n = 2126753390;
		int v = 1702766719;
//Scanner scanner = new Scanner(System.in);
//		int n = scanner.nextInt();
//		scanner.nextLine();
//		int v = scanner.nextInt();

		VersionControl.v = v;
		System.out.println(new Solution().firstBadVersion(n));

	}
	public static class Solution extends VersionControl {
		public int firstBadVersion(int n) {
			return find(1,n);
		}

		private int find(long l, long r){
			if (l > r ) return -1;
			if (l == r) return (int)l;
			int m = (int)((l + r) / 2);
			if (isBadVersion(m)){
				return find(l,m);
			}else{
				return find(m+1,r);
			}
		}


	}

	private static class VersionControl {
		static int v;
		boolean  isBadVersion(int i ){
			return i>=v;
		}
	}
}
