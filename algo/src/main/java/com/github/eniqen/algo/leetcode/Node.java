package com.github.eniqen.algo.leetcode;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	private Node() {}

	public Node(int val) { this(val, null, null, null); }

	private Node(int val, Node left, Node right, Node next) {
		this.val = val;
		this.left = left;
		this.right = right;
		this.next = next;
	}

	public static Node of(int val, Node left, Node right, Node next) {
		return new Node(val, left, right, next);
	}

	public static Node of(int val) {
		return of(val, null, null, null);
	}

	// level order traversal using 'next' pointer
	public void printLevelOrder() {
		Node nextLevelRoot = this;
		while (nextLevelRoot != null) {
			Node current = nextLevelRoot;
			nextLevelRoot = null;
			while (current != null) {
				System.out.print(current.val + " ");
				if (nextLevelRoot == null) {
					if (current.left != null)
						nextLevelRoot = current.left;
					else if (current.right != null)
						nextLevelRoot = current.right;
				}
				current = current.next;
			}
			System.out.println();
		}
	}
}
