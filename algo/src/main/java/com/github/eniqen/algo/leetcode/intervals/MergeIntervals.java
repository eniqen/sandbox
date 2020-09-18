package com.github.eniqen.algo.leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class MergeIntervals {
	public static void main(String[] args) {

	}

	public static int[][] merge(int[][] intervals) {

		if(intervals.length < 2) return intervals;

		List<int[]> result = new ArrayList<>();
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

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

		int[][] res = new int[result.size()][2];
		for(int i =0; i < result.size(); i++) {
			res[i] = result.get(i);
		}
		return res;
	}
}
