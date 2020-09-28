package com.github.eniqen.algo.leetcode.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class KClosestPointa {
	public static void main(String[] args) {
		int[][] points = new int[][]{
			new int[]{3, 3},
			new int[]{5 , -1},
			new int[]{-2, 4}
		};
		int k = 2;

		System.out.println(Arrays.deepToString(kClosest(points, k)));
	}

	private static int[][] kClosest(int[][] points, int k) {

		if(k <= 0) return new int[0][0];
		if(points == null || points.length <= k) return points;

		Arrays.sort(points, Comparator.comparingInt(a -> a[0] * a[0] + a[1] * a[1]));

		int[][] result = new int[k][2];

		System.arraycopy(points, 0, result, 0, k);

		return result;
	}
}
