package com.github.eniqen.algo.leetcode.two_pointers;

import java.util.Arrays;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class TripletClosest {
	public static void main(String[] args) {
		int [] raw = new int[]{-2, 0, 1, 2};
		System.out.println(threeSumClosest(raw, 2));
	}

	private static int threeSumClosest(int[] arr, int targetSum) {
		int diff = Integer.MAX_VALUE;
		Arrays.sort(arr);
		System.out.println(targetSum);
		for(int end = 0; end < arr.length; end++) {
			int current = arr[end];
			int left = end + 1;
			int right = arr.length - 1;

			while(left < right) {
				int sum = current + arr[left] + arr[right];
				if(Math.abs(targetSum - sum) < Math.abs(diff)) diff = targetSum - sum;
				if(sum > targetSum) right--;
				else left++;
			}
		}
		return targetSum - diff;
	}
}
