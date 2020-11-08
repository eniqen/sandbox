package com.github.eniqen.algo.leetcode.arrays;

import com.github.eniqen.algo.leetcode.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class MergeKArrays {
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        ListNode result = ListNode.of(0);

        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) {
                q.offer(new int[]{lists[i].val, i});
                lists[i] = lists[i].next;
            }
        }
        ListNode n = result;
        while(!q.isEmpty()) {
            int[]cur = q.poll();
            n.next = ListNode.of(cur[0]);
            n = n.next;
            if(lists[cur[1]] == null) continue;

            ListNode c = lists[cur[1]];
            q.offer(new int[]{c.val, cur[1]});
            lists[cur[1]] = lists[cur[1]].next;
        }

        return result.next;
    }
}
