package com.ziggy192.leetcode.explore.topInterviewQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Best Time to Buy and Sell Stock II
 * Say you have an array prices for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 *
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * Constraints:
 *
 * 1 <= prices.length <= 3 * 10 ^ 4
 * 0 <= prices[i] <= 10 ^ 4
 */
public class BestTimeToBuy {

	public static void main(String[] args) {
		new HashMap<>();
	}

	/**
	 * use dynamic programming
	 * time: O(n^2)
	 * space: O(n)
	 * l[i] : max profit possible at i
	 * maxProfit[i] if sell at i  =  max((price[i] - price[j]) + l[j-1])
	 * l[i] = max(maxProfit[i])
	 */
	public static class Solution{
		static int[] l;
		public int maxProfit(int[] prices) {
			l = new int[prices.length];
			int max = 0;
			Map<Integer, Integer> map = new HashMap<>();
			Arrays.fill(l, 0);
			for (int i = 1; i < prices.length; i++) {
				int curL = 0;
				for (int j = i - 1; j >= 0; j--) {
					if (prices[i] > prices[j]) {
						int profit = prices[i] - prices[j];
						int maxProfit;
						if (j > 0) {
							maxProfit = profit + l[j - 1];
						} else {
							maxProfit = profit;
						}
						if (maxProfit > curL) {
							curL = maxProfit;
						}
					}
				}
				if (curL > max) {
					max = curL;
				}
				l[i] = max;
			}
			return l[prices.length - 1];
		}
	}
}
