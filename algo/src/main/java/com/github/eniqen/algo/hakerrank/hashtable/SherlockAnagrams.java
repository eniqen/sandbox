package com.github.eniqen.algo.hakerrank.hashtable;

import java.util.*;
import java.util.function.BiFunction;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class SherlockAnagrams {
	public static void main(String[] args) {
		final String anagram = "cdcd";
		System.out.println(get(anagram));
	}

	static int get(String anagram) {
		final Map<String, Integer> map = new HashMap<>();
		final int[] counter = new int[] {0};
		for(int i = 0; i <= anagram.length(); i++) {
			for(int j = i + 1; j <= anagram.length(); j++) {
				final String current = anagram.substring(i, j);
				final char[] array = current.toCharArray();
				Arrays.sort(array);
				final String sorted = new String(array).intern();
				map.compute(sorted, new BiFunction<String, Integer, Integer>() {
					@Override
					public Integer apply(String s, Integer integer) {
						if(integer == null) {
							return 1;
						} else {
							counter[0] += integer;
							return integer + 1;
						}
					}
				});
			}
		}
		System.out.println(map);
		return counter[0];
	}
}
