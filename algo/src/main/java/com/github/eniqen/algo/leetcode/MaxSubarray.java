package com.github.eniqen.algo.leetcode;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class MaxSubarray {
	public static void main(String[] args) {
		int[] data = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(data));
	}

	static int maxSubArray(int[] nums) {
		int maxCur = nums[0];
		int maxGlobal = nums[0];
		for(int i = 1; i < nums.length; i++) {
			maxCur = Math.max(maxCur + nums[i], nums[i]);
			maxGlobal = Math.max(maxGlobal, maxCur);
		}
		return maxGlobal;
	}
}

