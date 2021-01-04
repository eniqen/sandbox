package com.github.eniqen.algo.leetcode.sliding_windows;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class RecentCalls {
	public static void main(String[] args) {
		RecentCounter recentCounter = new RecentCounter();
		System.out.println(recentCounter.ping(1));
		System.out.println(recentCounter.ping(100));
		System.out.println(recentCounter.ping(3001));
		System.out.println(recentCounter.ping(3002));
	}
}


class RecentCounter {
	final Queue<Integer> timeline;
	RecentCounter() {
		this.timeline = new LinkedList<>();
	}

	public int ping(int t) {
		timeline.offer(t);
		while(t - timeline.peek() > 3000) timeline.poll();
		return timeline.size();
	}
}