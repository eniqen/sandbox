package com.github.eniqen.algo.hakerrank.strings;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class ValidString {
	public static void main(String[] args) {
		String raw = "abccc";
		System.out.println(isValid(raw));

	}

	private static String isValid(String line) {
		int [] alphabetCount = new int[26];
		int count = 0;

		for (int i = 0; i < line.length(); i++) {
			alphabetCount[line.charAt(i) - 'a']++;
		}

		int diff = alphabetCount[0];

		for (int i = 0; i < line.length(); i++) {
			int current = alphabetCount[line.charAt(i) - 'a'];
			if(current != 0) {
				if(diff != current) {
					count++;
				}
				if(count == 2) return "NO";
			}
		}
		return "YES";
	}
}
