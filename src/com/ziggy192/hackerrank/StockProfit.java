package com.ziggy192.hackerrank;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StockProfit {
	public static int stockPairs(List<Integer> stocksProfit, long target) {
		Set<Long> set = new HashSet<>();
		int count = 0;
		// for duplicate profit case
		boolean hasDuplicate = false;
		for (Integer stockProfitInt : stocksProfit) {
			long stockProfit = stockProfitInt;
			if (!set.contains(stockProfit)) {
				if (set.contains(target - stockProfit)) {
					count++;
				}
				set.add(stockProfit);
			} else if (target % 2 == 0 && stockProfit == target / 2) {
				hasDuplicate = true;
			}
		}
		if (hasDuplicate) {
			count++;
		}
		return count;
	}
}
