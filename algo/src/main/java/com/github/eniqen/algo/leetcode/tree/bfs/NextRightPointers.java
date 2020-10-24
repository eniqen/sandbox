package com.github.eniqen.algo.leetcode.tree.bfs;

import com.github.eniqen.algo.leetcode.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class NextRightPointers {
	public static void main(String[] args) {
		Node root = new Node(12);
		root.left = new Node(7);
		root.right = new Node(1);
		root.left.left = new Node(9);
		root.right.left = new Node(10);
		root.right.right = new Node(5);
		NextRightPointers.connect(root);
		System.out.println("Level order traversal using 'next' pointer: ");
		root.printLevelOrder();
	}

	private static Node connect(Node root) {
		if(root == null) return root;
		Queue<Node> q = new LinkedList<>();
		q.offer(root);

		while(!q.isEmpty()) {
			int size = q.size();
			Node prev = null;
			for(int i = 0; i < size; i++) {
				Node cur = q.poll();

				if(prev != null) {
					prev.next = cur;
				}
				prev = cur;

				if(cur.left != null) q.offer(cur.left);
				if(cur.right != null) q.offer(cur.right);
			}
		}
		return root;
	}
}
