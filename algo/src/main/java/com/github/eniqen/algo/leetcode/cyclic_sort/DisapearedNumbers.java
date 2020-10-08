package com.github.eniqen.algo.leetcode.cyclic_sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class DisapearedNumbers {
	public static void main(String[] args) {
		System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
	}

	private static List<Integer> findDisappearedNumbers(int[] nums) {
		int i = 0;
		List<Integer> result = new ArrayList<>();
		while(i < nums.length) {
			if(nums[i] != nums[nums[i] - 1]) {
				int tmp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = tmp;
			} else {
				i++;
			}
		}

		for(i = 0; i < nums.length; i++) {
			if(nums[i] != i + 1) result.add(i + 1);
		}

		return result;
	}
}
