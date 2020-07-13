package com.github.eniqen.algo.leetcode;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class ListNode {
	int val;
	ListNode next;

	ListNode(int x, ListNode next) {
		this.val = x;
		this.next = next;
	}

	static ListNode of(int val) {
		return of(val, null);
	}

	static ListNode of(int val, ListNode next) {
		return new ListNode(val, next);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		ListNode curr = this;
		while(curr != null) {
			sb.append("[").append(curr.val).append("]");
			curr = curr.next;
		}
		return sb.toString();
	}
}
