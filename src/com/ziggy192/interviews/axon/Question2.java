package com.ziggy192.interviews.axon;

import java.util.Arrays;

public class Question2 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new double[]{ 6.233275446012816, 3.729773188641503, 5.455172317158121, 5.669779219821134})));
	}
	public static long[] solution(double[] prices) {
		return new Question2().sol(prices);
	}

	private long[] sol(double[] prices) {
		// calc rounded sum
		// calc floor sum
		double sum = 0;
		long floorSum = 0;
		for (double price : prices) {
			sum += price;
			floorSum += Math.floor(price);
		}
		long roundedSum = Math.round(sum);
		//calc v
		long v = roundedSum - floorSum;
		long count = v;
		// calc array for
		// sort array by the lower val
		// greeding: get the lower val if any left, -- count
		double[][] l = new double[prices.length][2];
		for (int i = 0; i < l.length; i++) {
			double[] pair = new double[2];
			pair[0] = prices[i] - Math.floor(prices[i]);
			pair[1] = Math.ceil(prices[i]) - prices[i];
			l[i] = pair;
		}
		Arrays.sort(l, (pair1, pair2) -> {
			double v1 = Math.min(pair1[0], pair1[1]);
			double v2 = Math.min(pair2[0], pair2[1]);
			return Double.compare(v1, v2);
		});

		


		long[] ret = new long[prices.length];
		// transform v times
		for (int i = 0; i < prices.length; i++) {
			long val;
			if (count > 0) {
				val = (long) Math.ceil(prices[i]);
				count--;
			} else {
				val = (long) Math.floor(prices[i]);
			}
			ret[i] = val;
		}
		return ret;
	}

}
