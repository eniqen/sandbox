package com.github.eniqen.algo.leetcode.arrays;

import java.util.Arrays;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class TwoSumSorted {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[]{2,7,9,11,13}, 9)));
	}


	private static int[] twoSum(int[] numbers, int target) {
		int left = 0;
		int right = numbers.length - 1;
		int[] result = new int[2];
		loop(numbers, target, left, right, result);
		return result;
	}

	private static void loop(int[] numbers, int target, int l, int r, int[]result) {
		if(l > r) return;
		int cur = numbers[l] + numbers[r];
		if(cur > target) {
			loop(numbers, target, l, r - 1, result);
		} else if(cur < target) {
			loop(numbers, target, l + 1, r, result);
		} else {
			result[0] = l + 1;
			result[1] = r + 1;
		}
	}
}
