package com.github.eniqen.algo.leetcode.arrays;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class RemoveDublicatesInPlace {

	public static void main(String[] args) {
		int[] arr = new int[]{0,0,1,1,1,2,2,3,3,4};
		System.out.println(removeDuplicates(arr));
	}

	private static int removeDuplicates(int[] nums) {
		if(nums == null) return 0;
		int start = 0;
		for(int end = 1; end < nums.length; end++) {
			if(nums[start] != nums[end]) {
				nums[++start] = nums[end];
			}
		}
		return start + 1;
	}
}
