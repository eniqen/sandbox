package com.github.eniqen.algo.hakerrank.strings;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class AlternativeCharacter {
	public static void main(String[] args) {
		String line = "ABABABAB";
		System.out.println(alternatingCharacters(line));
	}

	private static int alternatingCharacters(String s) {
		int count = 0;
		for(int i = 0; i < s.length() - 1; i++) {
			if(s.charAt(i) == s.charAt(i + 1)) {
				count++;
			}
		}
		return count;
	}
}
