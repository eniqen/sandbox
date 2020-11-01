package com.github.eniqen.algo.leetcode.heap;

import java.util.*;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class TopKKeywords {
	public static void main(String[] args) {
		String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
		int k = 2;
		System.out.println(topKFrequent(words, k));
	}

	private static List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> count = new HashMap<>();
		for(String s: words) count.put(s, count.getOrDefault(s, 0) + 1);
		List<String> res = new ArrayList<>(count.keySet());
		Collections.sort(res, (w1, w2) -> count.get(w1).equals(count.get(w2)) ? w1.compareTo(w2) : count.get(w2) - count.get(w1));
		return res.subList(0, k);
	}
}
