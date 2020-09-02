package com.github.eniqen.algo.leetcode.two_pointers;

import java.util.*;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class QuadrupleSumToTarget {
	public static void main(String[] args) {
		int [] raw =new int [] {4, 1, 2, -1, 1, -3};
		int target = 1;
		System.out.println(searchQuadruplets(raw, target));
	}

	private static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
		Arrays.sort(arr);
		Set<List<Integer>> quadruplets = new HashSet<>();
		for(int left = 0; left < arr.length - 3; left++) {
			for(int innerLeft = left + 1; innerLeft < arr.length - 2; innerLeft++) {
				int thirdIndex = innerLeft + 1;
				int fourthIndex = arr.length - 1;

				while(thirdIndex < fourthIndex) {
					int f = arr[left];
					int s = arr[innerLeft];
					int t = arr[thirdIndex];
					int fth = arr[fourthIndex];

					int sum = f + s + t + fth;

					if(sum > target){
						fourthIndex--;
					} else if(sum < target){
						thirdIndex++;
					} else {
						thirdIndex++;
						quadruplets.add(Arrays.asList(f, s, t, fth));
					}
				}
			}
		}
		return new ArrayList<>(quadruplets);
	}
}
