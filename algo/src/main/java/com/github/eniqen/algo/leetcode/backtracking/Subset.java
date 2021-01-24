package com.github.eniqen.algo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class Subset {
	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3};
		System.out.println(subset(arr));
		System.out.println("NON REC" + solution3(arr));
		gen(3,3);
	}

	private static List<List<Integer>> subset(int[] arr) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(0, arr, result, new ArrayList<>());
		return result;
	}

	private static void backtrack(int idx, int[] arr, List<List<Integer>> r, List<Integer> tmp) {
		r.add(new ArrayList<>(tmp));

		for(int i = idx; i < arr.length; i++) {
			tmp.add(arr[i]);
			backtrack(i + 1, arr, r, tmp);
			tmp.remove(tmp.size() - 1);
		}
	}

	private static void gen(int n, int m) {
		rec(n, m, 0, new int[n]);
	}

	private static void rec(int n, int m, int idx, int[] nums) {
		if(idx == n) {
			for (int num : nums) {
				System.out.print(num + " ");
			}
			System.out.println("\n");
			return;
		}

		for(int i = 1; i <= m; i++) {
			nums[idx] = i;
			rec(n, m, idx + 1, nums);
		}
	}

	static List<List<Integer>> solution3(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
		subsets.add(new ArrayList<>());
		for(int num: nums) {
			int n = subsets.size();
			for(int i = 0; i < n; i++) {
				List<Integer> temp = new ArrayList<>(subsets.get(i));
				temp.add(num);
				subsets.add(temp);
			}
		}
		return subsets;
	}
}
