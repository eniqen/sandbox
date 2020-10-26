package com.github.eniqen.algo.leetcode.cyclic_sort;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class ShuffleString {
	public static void main(String[] args) {
		String s = "codeleet";
		int[] indices = new int[]{4,5,6,7,0,2,1,3};
		System.out.println(restoreString(s, indices));
	}

	private static String restoreString(String s, int[] indices) {
		int i = 0;
		char[] word = s.toCharArray();
		while(i < indices.length) {
			if(i != indices[i]) {
				int tmp = indices[i];
				indices[i] = indices[tmp];
				indices[tmp] = tmp;

				char tmp2 = word[i];
				word[i] = word[indices[tmp]];
				word[indices[tmp]] = tmp2;

			} else {
				i++;
			}
		}
		return new String(word);
	}
}
