package com.github.eniqen.algo.leetcode.sliding_windows;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
class SubarrayProductLessThanK {
	private static List<List<Integer>> findSubarrays(int[] arr, int target) {
		List<List<Integer>> subarrays = new ArrayList<>();
		int prod = 1;
		int start = 0;
		for(int end = 0; end < arr.length; end++) {
			prod *= arr[end];

			while(prod >= target && start < arr.length) {
				prod /= arr[start++];
			}

			List<Integer> temp = new LinkedList<>();
			for(int i = end; i >= start; i--) {
				temp.add(0, arr[i]);
				subarrays.add(new ArrayList<>(temp));
			}
		}
		return subarrays;
	}

	private static int numSubarrayProductLessThanK(int[] nums, int k) {
		int product = 1;
		int left = 0;
		int count = 0;

		for(int end = 0; end < nums.length; end++) {
			product *= nums[end];
			while(product >= k && left < nums.length) {
				product /= nums[left++];
			}

			if(product < k) count += end - left + 1;

		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
		System.out.println(SubarrayProductLessThanK.numSubarrayProductLessThanK(new int[] { 2, 5, 3, 10 }, 30));
		System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] {8, 2, 6, 5 }, 50));
		System.out.println(SubarrayProductLessThanK.numSubarrayProductLessThanK(new int[] {8, 2, 6, 5 }, 50));
	}
}
