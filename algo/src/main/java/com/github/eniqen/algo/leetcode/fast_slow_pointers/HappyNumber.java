package com.github.eniqen.algo.leetcode.fast_slow_pointers;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class HappyNumber {
	public static void main(String[] args) {
		System.out.println(find(23));
		System.out.println(find(12));
	}

	private static boolean find(int num) {
		int slow = num;
		int  fast = num;
		do {
			slow = squareSum(slow);
			fast = squareSum(squareSum(fast));
		} while(slow != fast);
		return slow == 1;
	}

	private static int squareSum(int num) {
		int sum = 0;

		while(num > 0) {
			int shrink = num % 10;
			sum += shrink * shrink;
			num /= 10;
		}
		return sum;
	}
}
