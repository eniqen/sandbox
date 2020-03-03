package com.github.eniqen.algo.hakerrank;

import java.util.Arrays;

/**
 * @author Mikhail Nemenko {@literal <m.nemenko@elama.ru>}
 */
public class CountingValleys {
	public static void main(String[] args) {

		final char[] steps = "UDDDUDUU".toCharArray();
		final int[] representedSteps = new int[steps.length];

		for(int i = 0; i < steps.length; i++) {
			representedSteps[i] = steps[i] == 'U' ? 1 : -1;
		}

		System.out.println(Arrays.toString(representedSteps));
		System.out.println(valleyCount(representedSteps));
	}

	public static int valleyCount(int[] steps) {
		int count = 0;
		int seaLevel = 0;
		int index = 0;
		boolean handler = false;

		while(index < steps.length) {
			seaLevel += steps[index];

			if (seaLevel < 0) {
				handler = true;
			}
			if (handler && seaLevel == 0) {
				handler = false;
				count++;
			}
			index++;
		}
		return count;
	}
}
