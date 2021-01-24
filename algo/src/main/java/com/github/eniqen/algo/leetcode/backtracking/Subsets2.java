package com.github.eniqen.algo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class Subsets2 {
	public static void main(String[] args) {
		int[] nums = new int[] {1, 2, 2, 2};
		System.out.println(solution(nums));
		System.out.println(solution2(nums));
	}

	private static List<List<Integer>> solution(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
		int start;
		int end = 0;
		subsets.add(new ArrayList<>());
		for(int i = 0; i < nums.length; i++) {
			start = 0;
			if(i > 0 && nums[i] == nums[i - 1]) start = end + 1;
			end = subsets.size() - 1;
			for(int j = start; j <= end; j++) {
				List<Integer> tmp = new ArrayList<>(subsets.get(j));
				tmp.add(nums[i]);
				subsets.add(tmp);
			}
		}
		return subsets;
	}

	private static List<List<Integer>> solution2(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(0, nums, subsets, new ArrayList<>());
		return subsets;
	}

	private static void backtrack(int idx, int[] nums, List<List<Integer>> acc, List<Integer> tmp) {
		acc.add(new ArrayList<>(tmp));

		for(int i = idx; i < nums.length; i ++) {
			if(i > idx && nums[i] == nums[i - 1]) continue;
			tmp.add(nums[i]);
			backtrack(i + 1, nums, acc, tmp);
			tmp.remove(tmp.size() - 1);
		}
	}
}
