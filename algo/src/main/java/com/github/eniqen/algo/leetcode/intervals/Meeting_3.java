package com.github.eniqen.algo.leetcode.intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class Meeting_3 {
	public static void main(String[] args) {
		MyCalendarTwo calendar = new Meeting_3.MyCalendarTwo();
		System.out.println(calendar.book(10, 20));
		System.out.println(calendar.book(50, 60));
		System.out.println(calendar.book(10, 40));
		System.out.println(calendar.book(5, 15));
		System.out.println(calendar.book(5, 10));
		System.out.println(calendar.book(25, 55));
	}

	private static class MyCalendarTwo {
		final List<int[]> meetings;
		final List<int[]> overlaps;
		MyCalendarTwo() {
			this.meetings = new ArrayList<>();
			this.overlaps = new ArrayList<>();
		}

		boolean book(int start, int end) {
			for(int[] m: overlaps) {
				if(m[0] < end && start < m[1]) return false;
			}

			for(int[] m: meetings) {
				if(m[0] < end && start < m[1]) {
					overlaps.add(new int[]{Math.max(start, m[0]), Math.min(end, m[1])});
				}
			}

			meetings.add(new int[]{start, end});
			return true;
		}
	}
}
