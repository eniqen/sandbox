package com.github.eniqen.algo.leetcode;

import java.util.Arrays;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
class MinStack {

    /** initialize your data structure here. */
    private ListNode stack = null;
    
    public void push(int x) {
        int min = stack != null ? Math.min(x, getMin()) : x;
        ListNode head = ListNode.of(x, min);
            if(stack != null) head.next = stack;
            stack = head;
    }
    
    public void pop() {
        stack = stack.next;
    }
    
    public int top() {
        return stack.val;
    }
    
    public int getMin() {
        return stack.min;
    }
    
    static class ListNode {
        final int val;
        final int min;
        ListNode next;
        
        public ListNode(int v, int min) {
            this.val = v;
            this.min = min;
            this.next = null;
        }
        
        public static ListNode of(int v, int min) { 
            return new ListNode(v, min); 
        }
    }
}
   

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinS
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
        ListNode head = ListNode.of(x, min);
 */
