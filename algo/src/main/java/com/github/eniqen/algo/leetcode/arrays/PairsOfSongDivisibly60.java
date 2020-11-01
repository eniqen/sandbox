package com.github.eniqen.algo.leetcode.arrays;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class PairsOfSongDivisibly60 {
	public static void main(String[] args) {
		int[] length = new int[]{30,20,150,100,40};
		System.out.println(numPairsDivisibleBy60(length));
	}

	private static int numPairsDivisibleBy60(int[] time) {
		int pairs = 0;
		int[] minutes = new int[60];
		for(int t: time) {
			t %= 60; //30; 40; 30; 40; 20;
			int complement = t != 0 ? 60 - t : 0; //30; 20; 30; 20; 40;
			pairs += minutes[complement]; //1;2;
			minutes[t]++; // 30 -> 1; 40 -> 1; 30 -> 2; 40 -> 2;
		}
		return pairs;
	}
}
