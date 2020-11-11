package com.github.eniqen.algo.leetcode.two_heaps;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
class MedianFinder {
	private Queue<Integer> lo;
	private Queue<Integer> hi;
	public MedianFinder() {
		this.hi = new PriorityQueue<>();
		this.lo = new PriorityQueue<>((a, b) -> b - a);
	}

	public void addNum(int num) {
		if(lo.isEmpty() || lo.peek() > num) lo.offer(num);
		else hi.offer(num);

		Queue<Integer> b = lo.size() > hi.size() ? lo:hi;
		Queue<Integer> s = lo.size() > hi.size() ? hi:lo;

		if(b.size() - s.size() >= 2) s.offer(b.poll());
	}

	public double findMedian() {
		Queue<Integer> b = lo.size() > hi.size() ? lo:hi;
		Queue<Integer> s = lo.size() > hi.size() ? hi:lo;
		if(b.size() == s.size())return ((double)b.peek() + s.peek()) / 2;
		return b.peek();
	}

	public static void main(String[] args) {
		MedianFinder med = new MedianFinder();

		med.addNum(1);
		med.addNum(2);
		System.out.println(med.findMedian());
		med.addNum(3);
		System.out.println(med.findMedian());
	}
}