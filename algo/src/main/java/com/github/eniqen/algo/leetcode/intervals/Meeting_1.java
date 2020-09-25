package com.github.eniqen.algo.leetcode.intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class Meeting_1 {
	public static void main(String[] args) {
		MyCalendar calendar = new Meeting_1.MyCalendar();
		System.out.println(calendar.book(10, 20));
		System.out.println(calendar.book(15, 25));
		System.out.println(calendar.book(20, 30));
	}


	static class MyCalendar {
		final List<int[]> meetings;

		MyCalendar() {
			this.meetings = new ArrayList<>();
		}

		boolean book(int start, int end) {
			for (int[] meeting : meetings) {
				if (meeting[0] < end && start < meeting[1]) return false;
			}

			meetings.add(new int[]{start, end});
			return true;
		}
	}
}
