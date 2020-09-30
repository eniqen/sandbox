package com.github.eniqen.algo.leetcode.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.ToIntFunction;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class KClosestPoints {
	public static void main(String[] args) {
		int[][] points = new int[][]{
			new int[]{3, 3},
			new int[]{5 , -1},
			new int[]{-2, 4}
		};
		int k = 2;

		System.out.println(Arrays.deepToString(kClosest(points, k)));
	}

	//O(n log N)
	private static int[][] kClosest(int[][] points, int k) {

		if(k <= 0) return new int[0][0];
		if(points == null || points.length <= k) return points;

		Arrays.sort(points, Comparator.comparingInt(a -> a[0] * a[0] + a[1] * a[1]));

		int[][] result = new int[k][2];

		System.arraycopy(points, 0, result, 0, k);

		return result;
	}

	private static int[][] realTimeKClosest (int[][] points, int k) {
		PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt((ToIntFunction<int[]>) p -> p[0] * p[0] + p[1] * p[1]).reversed());

		for(int[] p: points) {
			q.offer(p);

			if(q.size() > k) {
				q.poll();
			}
		}

		int[][] result = new int[k][2];

		while(k > 0) {
			result[--k] = q.poll();
		}

		return result;
	}
}
