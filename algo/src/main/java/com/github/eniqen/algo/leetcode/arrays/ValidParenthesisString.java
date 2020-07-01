package com.github.eniqen.algo.leetcode.arrays;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class ValidParenthesisString {
	public static void main(String[] args) {
		String raw = "(*))";
		checkValid(raw);
	}

	public static boolean checkValid(String raw) {
		int l = 0;
		int h = 0;

		for(char c: raw.toCharArray()) {
			l += c == '(' ? 1 : -1;
			h += c != ')' ? 1 : -1;
			if(h < 0) break;
			l = Math.max(l, 0);
		}
		return l == 0;
	}
}
