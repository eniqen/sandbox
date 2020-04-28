package com.github.eniqen.algo.leetcode.arrays;

import java.util.Arrays;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class SingleNumber {
	public static void main(String[] args) {
		int [] nums = new int[] {4, 1, 2, 1 ,2};
		System.out.println(singleNumber(nums));
	}

	public static int singleNumber(int[] nums) {
		if (nums.length == 1) return nums[0];
		Arrays.sort(nums);
		int current = 1;
		while(current < nums.length) {
			int diff = nums[current - 1] - nums[current];
			if (diff < 0) return nums[current - 1];
			current +=2;
		}
		return nums[nums.length - 1];
	}
}
