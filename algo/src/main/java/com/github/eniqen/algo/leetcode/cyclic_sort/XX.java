package com.github.eniqen.algo.leetcode.cyclic_sort;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class XX {
	public static void main(String[] args) {
		for (int i = 1; ; i *= 2) {
			System.out.println(f(0, i));
		}
	}

	static int f(int idx, int max) {
		if (idx == max) return 0;
		return f(idx + 1, max) + 1;
	}
}
