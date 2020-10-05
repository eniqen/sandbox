package com.github.eniqen.algo.leetcode.cyclic_sort;

import java.util.Arrays;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class CyclicSort {
	public static void main(String[] args) {
		int[] data = new int[]{1, 5, 6, 4, 3, 2};
		sort(data);
		System.out.println(Arrays.toString(data));
	}

	private static void sort(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			while(nums[i] != i + 1) {
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			}
		}
	}
}
