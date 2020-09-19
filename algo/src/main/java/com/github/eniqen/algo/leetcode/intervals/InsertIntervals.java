package com.github.eniqen.algo.leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class InsertIntervals {
	public static void main(String[] args) {
		int[][] intervals = new int[][] {
			new int[]{1,3},
			new int[]{5,7},
			new int[]{8,12}
		};
		System.out.println(Arrays.deepToString(insert(intervals, new int[]{4,6})));
	}

	public static int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> result = new ArrayList<>();
		int index = 0;
		while(index < intervals.length && intervals[index][1] < newInterval[0]) {
			result.add(intervals[index++]);
		}

		while(index < intervals.length && intervals[index][0] <= newInterval[1]) {
			newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
			newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
			index++;
		}
		result.add(newInterval);

		while(index < intervals.length) {
			result.add(intervals[index++]);
		}

		return result.toArray(new int[0][]);
	}
}
