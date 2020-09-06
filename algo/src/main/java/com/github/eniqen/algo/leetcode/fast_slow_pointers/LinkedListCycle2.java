package com.github.eniqen.algo.leetcode.fast_slow_pointers;

import com.github.eniqen.algo.leetcode.ListNode;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class LinkedListCycle2 {
	public static void main(String[] args) {
		ListNode cycle = ListNode.of(4);
		ListNode t = ListNode.of(3, cycle);
		ListNode s = ListNode.of(2, t);
		ListNode head = ListNode.of(1, s);
		cycle.setNext(s);

		System.out.println(findCycleNode(head).val);
	}

	private static ListNode findCycleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		boolean found = false;

		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if(slow == fast) {
				slow = head;
				found = true;
				break;
			}
		}

		if(found) {
			while(slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		}
		return null;
	}
}
