package com.github.eniqen.algo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class Permutation {
	public static void main(String[] args) {
		int[]nums = new int[] {1,2,3};
		System.out.println(solution(nums));
	}

	private static List<List<Integer>> solution(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		permRec(0, nums, result, new ArrayList<>());
		return result;
	}

	private static void permRec(int idx, int[] nums, List<List<Integer>> acc, List<Integer> perm) {
		if(idx == nums.length) {
			acc.add(new ArrayList<>(perm));
			return;
		}

		for(int i = 0; i <= perm.size(); i ++) {
			perm.add(i, nums[idx]);
			permRec(idx + 1, nums, acc, perm);
			perm.remove(i);
		}
	}
}
