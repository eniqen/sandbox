package com.github.eniqen.algo.hakerrank.hashtable;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class TwoStrings {

	public static void main(String [] args) {
		final String x = "hi";
		final String y = "world";
		System.out.println(twoStrings(x, y));
	}

	private static String twoStrings(String x, String y) {
		final Set<Character> xSet = toUnique(x);
		final Set<Character> ySet = toUnique(y);
		final Iterator<Character> it = xSet.iterator();

		boolean handler = false;
		while(it.hasNext()) {
			final Character next = it.next();
			if (ySet.contains(next)) {
				handler = true;
				break;
			}
		}

		return handler ? "YES": "NO";
	}

	private static Set<Character> toUnique(String v) {
		final Set<Character> result = new HashSet<>(v.length());
		for(Character x: v.toCharArray()) {
			result.add(x);
		}
		return result;
	}
}
