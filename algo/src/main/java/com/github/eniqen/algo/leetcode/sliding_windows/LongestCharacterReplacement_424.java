package com.github.eniqen.algo.leetcode.sliding_windows;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class LongestCharacterReplacement_424 {
	public static void main(String[] args) {
		String s = "ABAB";
		int k = 2;
		System.out.print(characterReplacement(s, k));
	}

	private static int characterReplacement(String s, int k) {
		int[] freq = new int[26];
		int maxLength = 0;
		int diffCount = 0;
		int left = 0;

		for(int right = 0; right < s.length(); right++) {
			diffCount = Math.max(diffCount, ++freq[s.charAt(right) - 'A']);
			if(right - left + 1 - diffCount > k) {
				freq[s.charAt(left) - 'A']--;
				left++;
			}
			maxLength = Math.max(maxLength, right - left + 1);
		}

		return maxLength;
	}
}
