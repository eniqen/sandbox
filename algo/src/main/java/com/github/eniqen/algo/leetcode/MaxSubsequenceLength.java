package com.github.eniqen.algo.leetcode;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class MaxSubsequenceLength {
	public static void main(String[] args) {
		System.out.println(getMaxLength("aaaaaa"));
		System.out.println(getMaxLength("abbbbb"));
		System.out.println(getMaxLength("abc"));
		System.out.println(getMaxLength("aaaaabbbbbccccaaaabbbbbbbccccccccccccccssssssssssssss"));
	}

	static int getMaxLength(String line) {
		char[] chars = line.toCharArray();
		char curr = chars[0];
		int maxCur = 1;
		int maxGlob = 1;

		for (int i = 1; i < chars.length; i++) {
			if(curr == chars[i]) maxCur++;
			else {
				maxGlob = Math.max(maxGlob, maxCur);
				curr = chars[i];
				maxCur = 1;
			}
		}
		return Math.max(maxCur, maxGlob);
	}
}
