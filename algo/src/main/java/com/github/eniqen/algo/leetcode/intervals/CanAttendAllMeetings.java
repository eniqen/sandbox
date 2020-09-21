package com.github.eniqen.algo.leetcode.intervals;

import java.util.Arrays;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class CanAttendAllMeetings {
	public static void main(String[] args) {
		int[][] intervals = { new int[]{1, 4}, new int[]{2, 5}, new int[]{7, 9} };
		boolean result = canAttendAllAppointments(intervals);
		System.out.println("Can attend all appointments: " + result);

		int[][] intervals1 = { new int[]{6, 7}, new int[]{2, 4}, new int[]{8, 12} };
		result = canAttendAllAppointments(intervals1);
		System.out.println("Can attend all appointments: " + result);

		int[][] intervals2 = { new int[]{4, 5}, new int[]{2, 3}, new int[]{3, 6} };
		result = canAttendAllAppointments(intervals2);
		System.out.println("Can attend all appointments: " + result);

	}

	private static boolean canAttendAllAppointments(int[][] intervals) {
		if(intervals == null || intervals.length < 2) return true;
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		int index = 1;
		while(index < intervals.length && intervals[index - 1][1] < intervals[index++][0]){}
		return index == intervals.length;
	}
}


