package com.github.eniqen.algo.leetcode.sliding_windows;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class MinSubString {
	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}

	public static String minWindow(String s, String t) {
		Map<Character, Integer> target = new HashMap<>();
		Map<Character, Integer> window = new HashMap<>();

		for(Character c: t.toCharArray()) {
			target.put(c, target.getOrDefault(c, 0) + 1);
		}

		String result = "";
		int min = Integer.MAX_VALUE;
		int right = 0;
		for(int left = 0; left < s.length(); left++) {
			while(right < s.length() && !containTheSame(window, target)) {
				window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
				right++;
			}

			if(containTheSame(window, target) && min > right - left + 1) {
				result = s.substring(left, right);
				min = right - left + 1;
			}

			window.put(s.charAt(left), window.getOrDefault(s.charAt(left), 1) - 1);


		}

		return result;
	}

	private static boolean containTheSame(Map<Character, Integer> s, Map<Character, Integer> t) {
		if(s.size() < t.size()) return false;

		for(Map.Entry<Character, Integer> e: t.entrySet()) {
			if(s.get(e.getKey()) == null || s.get(e.getKey()) < e.getValue()) return false;
		}
		return true;
	}
}
