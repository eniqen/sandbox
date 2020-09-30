package com.github.eniqen.algo.leetcode.intervals;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class MyCalendarThree {
	public static void main(String[] args) {
		Calendar calendar = new MyCalendarThree.Calendar();
		System.out.println(calendar.book(10, 20)); // returns 1
		System.out.println(calendar.book(50, 60)); // returns 1
		System.out.println(calendar.book(10, 40)); // returns 2
		System.out.println(calendar.book(5, 15)); // returns 3
		System.out.println(calendar.book(5, 10)); // returns 3
		System.out.println(calendar.book(25, 55)); // returns 3
	}
	private static class Calendar {

		final Map<Integer, Integer> meetings;

		Calendar() {
			this.meetings = new TreeMap<>();
		}

		int book(int start, int end) {
			Integer s = meetings.getOrDefault(start, 0);
			Integer e = meetings.getOrDefault(end, 0);
			meetings.put(start, s + 1);
			meetings.put(end, e - 1);

			int result = 0;
			int cur = 0;

			for(Map.Entry<Integer, Integer> kv: meetings.entrySet()) {
				cur += kv.getValue();
				result = Math.max(result, cur);
			}
			return result;
		}
	}
}