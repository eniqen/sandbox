package com.github.eniqen.algo.leetcode.heap;

import java.util.*;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class TopKFrequent {
	public static void main(String[] args) {
		int[] data = new int[]{1,1,1,2,2,3};
		int k = 2;
		System.out.println(Arrays.toString(topKFrequent(data, k)));
	}

	private static int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> counts = new HashMap<>();
		for(Integer n: nums) counts.put(n, counts.getOrDefault(n, 0) + 1);
		Queue<Integer> topK = new PriorityQueue<>(Comparator.comparingInt(counts::get));

		for(Integer n: counts.keySet()) {
			topK.offer(n);
			if(topK.size() > k) topK.poll();
		}

		int[] result = new int[k];

		while(k > 0) {
			result[--k] = topK.poll();
		}
		return result;
	}
}
