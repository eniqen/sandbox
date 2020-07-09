package com.github.eniqen.algo.leetcode.sliding_windows;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class FindingAnagrams {
	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";

		System.out.print(findAnagrams(s, p));
	}

	public static List<Integer> findAnagrams(String s, String p) {
		int k = p.length();
		int n = s.length();
		List<Integer> result = new LinkedList<>();
		if(k > n) return result;
		int [] pHash = getHash(p.toCharArray());
		int[] toCompare = new int[26];
		int start = 0;
		for(int end = 0; end < s.length(); end++) {
			toCompare[s.charAt(end) - 'a']++;
			if(end + 1 >= k) {
				if(isEqual(toCompare, pHash)) {
					result.add(start);
				}
				toCompare[s.charAt(start) - 'a']--;
				start++;
			}
		}
		return result;
	}

	private static int[] getHash(char[] raw) {
		int[] hash = new int[26];
		for (char aRaw : raw) {
			hash[aRaw - 'a']++;
		}
		return hash;
	}

	private static boolean isEqual(int[] raw, int[] original) {
		if(raw.length != original.length) return false;
		for(int i = 0; i < raw.length; i++) {
			if(raw[i] != original[i]) return false;
		}
		return true;
	}
}
