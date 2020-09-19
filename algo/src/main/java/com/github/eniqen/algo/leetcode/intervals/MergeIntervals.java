package com.github.eniqen.algo.leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class MergeIntervals {
	public static void main(String[] args) {

		int[][] intervals = new int[][] {
				new int[]{1,3},
				new int[]{2,6},
				new int[]{8,10},
				new int[]{15,18}
		};
		System.out.println(Arrays.deepToString(merge(intervals)));
	}

	private static int[][] merge(int[][] intervals) {

		if(intervals.length < 2) return intervals;

		List<int[]> result = new ArrayList<>();
		Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

		int[] prev = intervals[0];

		for(int i = 1; i < intervals.length; i++) {
			int[] cur = intervals[i];

			if(prev[1] >= cur[0]) {
				prev[1] = Math.max(cur[1], prev[1]);
			} else {
				result.add(prev);
				prev = cur;
			}
		}

		result.add(prev);

		return result.toArray(new int[0][]);
	}
}
