package com.github.eniqen.algo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class Two_Sum_1 {
	public static void main(String[] args) {
		int [] raw = new int[] {2, 7, 11, 15};
		int target = 9;

		System.out.print(Arrays.toString(twoSum(raw, target)));

	}

	private static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> store = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			Integer curr = nums[i];
			if(store.containsKey(curr)) {
				return new int[] {store.get(curr), i};
			} else {
				store.put(target - curr, i);
			}
		}
		return new int[] {-1, -1};
	}
}
