package com.github.eniqen.algo.hakerrank.arrays;

import java.util.Arrays;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class LeftRotation {

	public static void main(String[] args) {
		int [] array = new int[] { 1 ,2 ,3 ,4 ,5 };
		System.out.println(Arrays.toString(rotLeft(array, 2)));
	}

	 private static int[] rotLeft(int[] custom, int d) {
		int [] result = new int[custom.length];
		int index = 0;
		for(int i = d % custom.length; i < d % custom.length + custom.length; i++) {
			result[index] = custom[i % custom.length];
			index++;
		}
		return result;
	}
}
