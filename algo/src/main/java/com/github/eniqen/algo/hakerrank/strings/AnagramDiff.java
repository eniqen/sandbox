package com.github.eniqen.algo.hakerrank.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class AnagramDiff {
	public static void main(String[] args) {
		String a = "showman";
		String b = "woman";
		System.out.println(makeAnagram(a, b));
	}

	static int makeAnagram(String a, String b) {
		int count = 0;
		final Map<Character, Long> freq = new HashMap<>();

		for (int i = 'a'; i <= 'z'; i++) {
			freq.put((char) i, 0L);
		}

		for(char x: a.toCharArray()) {
			freq.merge(x, 1L, Long::sum);
		}

		for(char next: b.toCharArray()) {
			freq.put(next, freq.get(next) - 1);
		}

		for(Long v: freq.values()) {
			count += Math.abs(v);
		}
		return count;
	}
}
