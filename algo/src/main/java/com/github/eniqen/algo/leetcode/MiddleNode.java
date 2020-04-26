package com.github.eniqen.algo.leetcode;

import java.util.Arrays;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class MiddleNode {
	public static void main(String[] args) {
		System.out.println(singleNumber(nums));
	}

*/
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    static ListNode middleNode(ListNode head) {
        List<ListNode>array = new ArrayList<>();
        array.add(head);
        while(head.next != null){
           array.add(head.next);
           head = head.next;
        }
        return array.get(array.size() / 2);
    }
}