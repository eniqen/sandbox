package com.github.eniqen.algo.hakerrank.sort;
import java.util.Arrays;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class MaxToys {
	public static void main(String[] args) {
		final int[] prices = new int[] {1, 12, 5, 111, 200, 1000, 10};
		System.out.println(maximumToys(prices, 50));
	}

	private static int maximumToys(int[] prices, int k) {
		int max = 0;
		int index = 0;
		Arrays.sort(prices);
		System.out.println(Arrays.toString(prices));
		while(k - prices[index] > 0 && index < prices.length) {
			k -= prices[index];
			index++;
			max++;
		}
		return max;
	}
}
