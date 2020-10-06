package com.github.eniqen.algo.leetcode.cyclic_sort;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class MissingNumber {
	public static void main(String[] args) {
		System.out.println(missingNumber(new int[]{3, 0, 1}));
	}

	private static int missingNumber(int[] nums) {
		int index = 0;
		while(index < nums.length) {
			if(nums[index] < nums.length && nums[nums[index]] != nums[index]) {
				int tmp = nums[nums[index]];
				nums[nums[index]] = nums[index];
				nums[index] = tmp;
			} else {
				index++;
			}
		}

		for(int i =0; i < nums.length; i++) {
			if(nums[i] != i) return i;
		}

		return nums.length;
	}
}
