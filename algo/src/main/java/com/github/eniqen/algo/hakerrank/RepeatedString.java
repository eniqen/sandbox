package com.github.eniqen.algo.hakerrank;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class RepeatedString {
	public static void main(String[] args) {
		String s = "abcac";
		int n = 11;
		System.out.println(repeatedString(s, n));
	}

	private static long repeatedString(String s, long n) {
		char[] data = s.toCharArray();
		int fullCounter = helper(data, data.length);

		long diff = n % data.length;

		return diff == 0
				? (n / data.length) * fullCounter
				: fullCounter * ((n - diff) / data.length) + helper(data, diff);
	}

	private static int helper(char[] data, long n) {
		int counter = 0;

		for(int i = 0; i < n; i++) {
			counter += data[i] == 'a' ? 1 : 0;
		}

		return counter;
	}
}
