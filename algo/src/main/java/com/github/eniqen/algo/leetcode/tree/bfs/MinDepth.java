package com.github.eniqen.algo.leetcode.tree.bfs;

import com.github.eniqen.algo.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class MinDepth {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree Minimum Depth: " + MinDepth.minDepth(root));
		root.left.left = new TreeNode(9);
		root.right.left.left = new TreeNode(11);
		System.out.println("Tree Minimum Depth: " + MinDepth.minDepth(root));
	}

	private static int minDepth(TreeNode root) {
		if(root == null) return 0;

		Queue<TreeNode> q = new LinkedList<>();
		int level = 0;
		q.offer(root);
		while(!q.isEmpty()) {
			int size = q.size();
			level++;

			for(int i = 0; i < size; i++) {
				TreeNode cur = q.poll();
				if(cur.left == null && cur.right == null) return level;

				if(cur.left!= null) q.offer(cur.left);
				if(cur.right != null) q.offer(cur.right);
			}
		}
		return level;
	}
}

