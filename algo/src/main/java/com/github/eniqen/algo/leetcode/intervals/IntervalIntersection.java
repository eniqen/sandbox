package com.github.eniqen.algo.leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class IntervalIntersection {
	public static void main(String[] args) {
		int [][]a = new int[][] {
				new int[] {0, 2},
				new int[] {5, 10},
				new int[] {13, 20},
				new int[] {24, 25}
		};

		int [][]b = new int[][] {
				new int[] {1, 5},
				new int[] {8, 12},
				new int[] {15, 24},
				new int[] {25, 26}
		};

		System.out.println(Arrays.deepToString(intervalIntersection(a, b)));
	}

	private static int[][] intervalIntersection(int[][] A, int[][] B) {
		List<int[]> result = new ArrayList<>();

		int left = 0;
		int right = 0;

		while(left < A.length && right < B.length) {

			int[] leftSlot = A[left];
			int[] rightSlot = B[right];

			if(leftSlot[1] >= rightSlot[0] && leftSlot[0] <= rightSlot[1]) {
				int start = Math.max(leftSlot[0], rightSlot[0]);
				int end   = Math.min(leftSlot[1], rightSlot[1]);
				result.add(new int[]{start, end});
			}

			if(leftSlot[1] < rightSlot[1]) {
				left++;
			} else {
				right++;
			}
		}

		return result.toArray(new int[0][]);
	}
}
