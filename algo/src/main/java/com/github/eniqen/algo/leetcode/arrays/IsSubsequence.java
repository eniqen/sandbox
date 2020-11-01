package com.github.eniqen.algo.leetcode.arrays;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class IsSubsequence {
	public static void main(String[] args) {
		String s = "abc";
		String t = "ahbgdc";
		System.out.println(isSubsequence(s, t));
	}

	private static boolean isSubsequence(String s, String t) {
		int lastIndex = -1;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			lastIndex = t.indexOf(c, ++lastIndex);
			if(lastIndex == -1) return false;
		}
		return true;
	}
}
