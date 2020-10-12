package com.github.eniqen.algo.leetcode.linkedlist;

import com.github.eniqen.algo.leetcode.ListNode;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class ReverseSinglyList {
	public static void main(String[] args) {
		ListNode root = ListNode.of(1, ListNode.of(2, ListNode.of(3, ListNode.of(4, ListNode.of(5)))));
		System.out.println(reverseList(root));
	}

	private static ListNode reverseList(ListNode head) {
		ListNode result = null;
		while(head != null) {
			ListNode temp = head;
			head = head.next;
			temp.next = result;
			result = temp;
		}
		return result;
	}
}
