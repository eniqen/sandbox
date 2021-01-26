package com.github.eniqen.algo.leetcode.arrays;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class RotateString {
	public static void main(String[] args) {
		System.out.println(rotateString("abcde", "cdeab"));
		System.out.println(rotateString("abcde", "abced"));
	}

	public static boolean rotateString(String A, String B) {
		if(A.length() != B.length()) return false;
		if(A.isEmpty() && B.isEmpty()) return true;
		StringBuilder sb = new StringBuilder(A);
		int start = 0;
		while(start < A.length()) {
			sb.deleteCharAt(0);
			sb.append(A.charAt(start));
			if(sb.toString().equals(B)) return true;
			start++;
		}

		return false;
	}
}
