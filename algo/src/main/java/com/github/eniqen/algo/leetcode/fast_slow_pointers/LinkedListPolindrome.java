package com.github.eniqen.algo.leetcode.fast_slow_pointers;

import com.github.eniqen.algo.leetcode.ListNode;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class LinkedListPolindrome {
	public static void main(String[] args) {
		ListNode node = ListNode.of(1, ListNode.of(2, ListNode.of(1)));
		ListNode node2 = ListNode.of(1, ListNode.of(2, ListNode.of(3)));
		System.out.println(isPalindrome(node));
		System.out.println(isPalindrome(node2));
	}

	private static boolean isPalindrome(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode reversed = reverse(slow);

		while(reversed != null && head != slow) {
			if(reversed.val != head.val) return false;
			reversed = reversed.next;
			head = head.next;
		}
		return true;
	}

	private static ListNode reverse(ListNode head) {
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
