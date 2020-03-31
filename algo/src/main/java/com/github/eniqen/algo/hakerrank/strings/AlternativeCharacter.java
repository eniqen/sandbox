package com.github.eniqen.algo.hakerrank.strings;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class AlternativeCharacter {
	public static void main(String[] args) {
		String line = "ABABABAB";
		System.out.println(alternatingCharacters(line));
	}

	static int alternatingCharacters(String s) {
		int count = 0;
		if(s.length() == 1) return 1;
		int flag = (int) s.charAt(0) - 'A';
		for(int i = 1; i < s.length(); i++) {
			int currentFlag = s.charAt(i) - 'A';
			if(flag == currentFlag) {
				count++;
			} else {
				flag = currentFlag;
			}
		}
		return count;
	}
}
