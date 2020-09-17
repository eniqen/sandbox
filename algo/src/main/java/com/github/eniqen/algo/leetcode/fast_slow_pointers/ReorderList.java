package com.github.eniqen.algo.leetcode.fast_slow_pointers;

import com.github.eniqen.algo.leetcode.ListNode;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class ReorderList {
	public static void main(String[] args) {
		ListNode node = ListNode.of(1, ListNode.of(2, ListNode.of(3, ListNode.of(4, ListNode.of(5)))));
		reorder(node);
		System.out.println(node);
	}

	private static void reorder(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode first  = head;
		ListNode second = reverse(slow);

		while(first != null && second != null) {
			ListNode tmp = first.next;
			first.next = second;
			first = tmp;

			tmp = second.next;
			second.next = first;
			second = tmp;
		}
	}

	private static ListNode reverse(ListNode head){
		ListNode result = null;

		while(head != null){
			ListNode tmp = head;
			head = head.next;
			tmp.next = result;
			result = tmp;
		}
		return result;
	}
}
