package com.github.eniqen.algo.leetcode;

import java.util.Arrays;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class MaxProfit {
	public static void main(String[] args) {
		int [] data = new int[] {7,1,5,3,6,4};
		int [] data2 = new int[] {1,2,3,4,5,6};
		int [] data3 = new int[] {7,6,5,4,3,2};

		System.out.println(maxProfit(data));
		System.out.println(maxProfit(data2));
		System.out.println(maxProfit(data3));
 	}

	private static int maxProfit(int[] prices) {
		int max_profit = 0;
		int high = prices.length;

		for(int i = 1; i < high; i++) {
			while(i < high && prices[i - 1] > prices[i]) {
				i++;
			}
			int toByu = prices[i - 1];
			while(i < high && prices[i - 1] < prices[i]) {
				i++;
			}
			max_profit += prices[i - 1] - toByu;
		}

		return max_profit;
	}
}
