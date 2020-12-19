package com.github.eniqen.algo.leetcode.arrays;

import java.util.Arrays;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class SumUpToZero {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(3)));
		System.out.println(Arrays.toString(solution(4)));
	}
	private static int[] solution(int N) {
		if(N < 1) return new int[0];
		if(N == 1) return new int[]{0};

		int[] result = new int[N];

		for(int i = 0; i < N / 2; i++) {
			result[N - i - 1] = N / 2 - i;
			result[i] = -1 * result[N - i - 1];
		}
		return result;
	}

}
