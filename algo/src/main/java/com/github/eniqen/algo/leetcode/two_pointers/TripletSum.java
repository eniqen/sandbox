package com.github.eniqen.algo.leetcode.two_pointers;

import java.util.*;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class TripletSum {
	public static void main(String[] args) {
		int [] nums = new int[] {-1, 0, 1, 2, -1, -4};
		System.out.println(treeSum(nums));
	}

	private static List<List<Integer>>treeSum(int[] nums) {
		Arrays.sort(nums);
		Set<List<Integer>> result = new HashSet<>();

		for(int end = 0; end < nums.length; end++) {
			int current = nums[end];
			int left = end + 1;
			int right = nums.length - 1;

			while(left < right) {

				int sum = current + nums[left] + nums[right];

				if(sum > 0) right--;
				else if(sum < 0) left++;
				else {
					result.add(Arrays.asList(current, nums[left], nums[right]));
					left++;
					right--;
				}
			}
		}

		return new ArrayList<>(result);
	}
}
