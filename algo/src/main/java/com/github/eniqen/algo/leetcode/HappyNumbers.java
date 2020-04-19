package com.github.eniqen.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class HappyNumbers {
	public static void main(String[] args) {
		System.out.println(isHappy(2));
		System.out.println(isHappy(19));
	}

	static boolean isHappy(int n) {
		Set<Long> cicle = new HashSet<>();
		cicle.add((long)n);
		long current = getPowSum((long)n);
		cicle.add(current);
		while(current != 1) {
			current = getPowSum(current);
			if (cicle.contains(current)) return false;
			cicle.add(current);
		}
		return true;
	}

	private static long getPowSum(long init) {
		long start = init;
		long sum = 0L;
		while(start > 9) {
			long rest = start % 10L;
			sum += (long) Math.pow(rest, 2);
			start = start / 10L;
		}
		long result = (long) Math.pow(start, 2) + sum;
		return result;
	}
}
