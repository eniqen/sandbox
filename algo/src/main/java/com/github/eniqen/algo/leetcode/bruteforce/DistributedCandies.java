package com.github.eniqen.algo.leetcode.bruteforce;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class DistributedCandies {
	public static void main(String[] args) {
		int[] t = new int[] {1,1,2,2,3,3};
 		System.out.println(solution(t));
	}

	private static int solution(int[] candyType) {
		Map<Integer, Integer> c = new HashMap<>();
		for(int t: candyType) {
			c.put(t, c.getOrDefault(t, 0) + 1);
		}

		int count = candyType.length / 2;

		return count < c.size() ? count: c.size() ;
	}
}
