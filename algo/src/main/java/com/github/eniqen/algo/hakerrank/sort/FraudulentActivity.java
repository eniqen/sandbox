package com.github.eniqen.algo.hakerrank.sort;

import java.util.Arrays;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class FraudulentActivity {
	public static void main(String[] args) {
		int [] expenditure = new int[] {2, 3, 4, 2, 3, 6, 8, 4, 5};
		System.out.println(notificationCount(expenditure, 5));
//		System.out.println(getMedian(new int[] {1, 2, 3, 4, 5}, 0, 4));
	}

	static int notificationCount(int[] expenditure, int d) {
		int count = 0;
		int start = 0;

		while(start + d < expenditure.length) {
			double median = getMedian(expenditure, start, d);
			int current = expenditure[start + d];
			if(current >= median * 2) count++;
			start++;
		}
		return count;
	}

	private static double getMedian(int[] expenditure, int from, int d) {
		int[] copy = Arrays.copyOfRange(expenditure, from, from + d);
		Arrays.sort(copy);
		int index = (from + d - 1) / 2;
		return d % 2 == 0
			   ? (double) (copy[index] + copy[index + 1]) / 2
			   : copy[index];
	}
}
