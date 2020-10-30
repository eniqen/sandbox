package com.github.eniqen.algo.leetcode.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class MostCommonWord {
	public static void main(String[] args) {
		String par = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = new String[]{"hit"};
		System.out.println(mostCommonWord(par, banned));
	}

	private static  String mostCommonWord(String paragraph, String[] banned) {
		String[] words = paragraph.toLowerCase().split("\\W+");
		Set<String> ban = new HashSet<>();
		for(String s:banned) ban.add(s.toLowerCase());
		String max = null;
		Map<String, Integer> count = new HashMap<>();
		for(String word: words) {
			if(!ban.contains(word)) {
				count.put(word, count.getOrDefault(word, 0) + 1);
				if(max == null || count.get(word) > count.getOrDefault(max, 0)) max = word;
			}
		}
		return max;
	}
}
