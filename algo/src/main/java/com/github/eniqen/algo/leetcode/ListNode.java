package com.github.eniqen.algo.leetcode;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x, ListNode next) {
		this.val = x;
		this.next = next;
	}

	public static ListNode of(int val) {
		return of(val, null);
	}

	public void setNext(ListNode node) {
		this.next = node;
	}

	public static ListNode of(int val, ListNode next) {
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
