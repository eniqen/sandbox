package com.github.eniqen.algo.leetcode.arrays;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class SlowestKey {
	public static void main(String[] args) {
		int[] times = new int[]{9,29,49,50};
		String keys = "cbcd";
		System.out.println(slowestKey(times, keys));
	}

	private static char slowestKey(int[] releaseTimes, String keysPressed) {
		char bestChar = keysPressed.charAt(0);
		int maxTime = releaseTimes[0];
		for(int i = 1; i < releaseTimes.length; i++) {
			int diff = releaseTimes[i] - releaseTimes[i - 1];
			if(diff > maxTime || diff == maxTime && keysPressed.charAt(i) > bestChar) {
				maxTime = diff;
				bestChar = keysPressed.charAt(i);
			}
		}
		return bestChar;
	}
}
