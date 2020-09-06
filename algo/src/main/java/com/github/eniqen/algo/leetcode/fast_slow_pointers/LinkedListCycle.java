package com.github.eniqen.algo.leetcode.fast_slow_pointers;

import com.github.eniqen.algo.leetcode.ListNode;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class LinkedListCycle {
	public static void main(String[] args) {
		ListNode cycle = ListNode.of(4);
		ListNode t = ListNode.of(3, cycle);
		ListNode s = ListNode.of(2, t);
		ListNode head = ListNode.of(1, s);
		cycle.setNext(s);

		System.out.println(hasCycle(head));
	}

	private static boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(slow == fast) return true;
		}

		return false;
	}
}
