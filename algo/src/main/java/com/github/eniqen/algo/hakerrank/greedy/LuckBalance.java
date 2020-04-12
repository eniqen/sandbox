package com.github.eniqen.algo.hakerrank.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class LuckBalance {
	public static void main(String[] args) {
		int [][] data = new int [][] {
			{5, 1},
			{1, 1},
			{2, 1},
			{4, 0}
		};

		System.out.println(luckBalance(2, data));
	}

	private static int luckBalance(int k, int[][] contests) {
		Arrays.sort(contests, Comparator.comparingInt(x -> x[0]));
		int result = 0;
		int important = k;
		for(int i = contests.length - 1; i >= 0; i--) {
			int current = contests[i][0];

			if(contests[i][1] == 1) {
				if(important > 0) result += current;
				else result -= current;
				important--;
			} else result += current;

		}
		return result;
	}
}
