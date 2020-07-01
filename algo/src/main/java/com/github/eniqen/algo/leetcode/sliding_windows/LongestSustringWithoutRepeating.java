package com.github.eniqen.algo.leetcode.sliding_windows;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class LongestSustringWithoutRepeating {
	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s));
	}

	public static int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> freq = new HashMap<>();
		int k = 1;
		int start = 0;
		int maxLength = 0;

		for(int end = 0; end < s.length(); end++) {
			Character cur = s.charAt(end);
			freq.put(cur, freq.getOrDefault(cur, 0) + 1);

			while(freq.get(cur) > k) {
				freq.put(s.charAt(start), freq.get(s.charAt(start)) - 1);
				start++;
			}
			maxLength = Math.max(maxLength, end - start + 1);
		}
		return maxLength;
	}
}
