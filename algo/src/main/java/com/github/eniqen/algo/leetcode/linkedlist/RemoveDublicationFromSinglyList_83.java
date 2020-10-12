package com.github.eniqen.algo.leetcode.linkedlist;

import com.github.eniqen.algo.leetcode.ListNode;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class RemoveDublicationFromSinglyList_83 {
	public static void main(String[] args) {
		ListNode listNode = ListNode.of(1, ListNode.of(2, ListNode.of(2, ListNode.of(3, ListNode.of(3)))));
		System.out.println(deleteDuplicates(listNode));
	}

	private static ListNode deleteDuplicates(ListNode head) {
		ListNode curr = head;
		while(curr != null) {
			while(curr.next != null && curr.next.val == curr.val) {
				curr.next = curr.next.next;
			}
			curr = curr.next;
		}
		return head;
	}
}
