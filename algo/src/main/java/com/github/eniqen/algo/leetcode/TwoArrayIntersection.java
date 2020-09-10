package com.github.eniqen.algo.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class TwoArrayIntersection {
	public static void main(String[] args) {
		int [] nums1 = new int[]{4,9,5};
		int [] nums2 = new int[]{9,4,9,8,4};

		System.out.println(Arrays.toString(intersection(nums1, nums2)));
	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> n1 = toSet(nums1);
		Set<Integer> n2 = toSet(nums2);

		n1.retainAll(n2);

		int [] result = new int[n1.size()];

		int index = 0;

		for(int x: n1) {
			result[index] = x;
			index++;
		}

		return result;
	}

	private static Set<Integer> toSet(int[] arr) {
		Set<Integer> set = new HashSet<>();

		for (int anArr : arr) {
			set.add(anArr);
		}

		return set;
	}
}
