package com.github.eniqen.algo.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class LastStoneWeight {
	public static void main(String[] args) {
		int[] stones = new int[] {2,7,4,1,8,1};
		System.out.println(lastStoneWeight(stones));
 	}

	private static int lastStoneWeight(int [] stones) {
		Queue<Integer> stonesWeight = new PriorityQueue<>(Comparator.reverseOrder());
		for (int stone : stones) {
			stonesWeight.add(stone);
		}

		return get(stonesWeight);
	}

	private static int get(Queue<Integer> stones) {
		while(stones.size() > 1) {
			int first = stones.remove();
			int second = stones.remove();
			int diff = first - second;
			if(diff > 0) stones.add(diff);
		}
		return stones.isEmpty() ? 0 : stones.remove();
	}
}
