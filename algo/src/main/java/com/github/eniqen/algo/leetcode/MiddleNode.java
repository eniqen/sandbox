package com.github.eniqen.algo.leetcode;

import java.util.ArrayList;

import java.util.List;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class MiddleNode {
	public static void main(String[] args) {
	    ListNode node = ListNode.of(5, ListNode.of(6, ListNode.of(7, ListNode.of(8))));
	    System.out.println(middleNode(node));
	}

    static ListNode middleNode(ListNode head) {
        List<ListNode> array = new ArrayList<>();
        array.add(head);
        while(head.next != null){
           array.add(head.next);
           head = head.next;
        }
        return array.get(array.size() / 2);
    }
}