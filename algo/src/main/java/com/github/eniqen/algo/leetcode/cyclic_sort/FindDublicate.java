package com.github.eniqen.algo.leetcode.cyclic_sort;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class FindDublicate {
	public static void main(String[] args) {
		int[] data = new int[] {1,3,4,2,2};
		System.out.println(findDuplicate(data));
 	}

	private static int findDuplicate(int[] nums) {
		int i = 0;
		while(i < nums.length) {
			if(nums[i] != nums[nums[i] - 1]) {
				int tmp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = tmp;
			} else {
				i++;
			}
		}

		for(int j = 0; j < nums.length; j++) {
			if(nums[j] - 1 != j) return nums[j];
		}
		return nums.length;
	}
}
