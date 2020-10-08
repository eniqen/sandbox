package com.github.eniqen.algo.leetcode.cyclic_sort;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class FirstMissingPositive {
	public static void main(String[] args) {
		System.out.println(firstMissingPositive(new int[] {-3, 1, 5, 4, 2}));
		System.out.println(firstMissingPositive(new int[] {3, -2, 0, 1, 2}));
		System.out.println(firstMissingPositive(new int[] {3, 2, 5, 1}));
	}

	private static int firstMissingPositive(int[] nums) {
		int i = 0;
		while(i < nums.length) {
			if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
				int tmp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = tmp;
			} else {
				i++;
			}
		}

		for(i = 0; i < nums.length; i++) {
			if(nums[i] != i + 1) return i + 1;
		}

		return nums.length + 1;
	}
}
