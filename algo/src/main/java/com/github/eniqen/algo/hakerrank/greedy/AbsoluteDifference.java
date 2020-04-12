package com.github.eniqen.algo.hakerrank.greedy;

import java.util.Arrays;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class AbsoluteDifference {
	public static void main(String[] args) {
		int [] raw = new int[] {3, -7, 0};
		System.out.println(minimumAbsoluteDifference(raw));
	}

	private static int minimumAbsoluteDifference(int[] arr) {
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int minAbsDiff = Math.abs(arr[0] - arr[1]);
		for(int i = 1; i < arr.length - 1; i++) {
			int cur = Math.abs(arr[i] - arr[i + 1]);
			minAbsDiff = minAbsDiff < cur ? minAbsDiff : cur;
		}
		return minAbsDiff;
	}
}
