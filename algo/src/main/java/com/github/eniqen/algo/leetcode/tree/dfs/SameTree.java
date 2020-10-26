package com.github.eniqen.algo.leetcode.tree.dfs;

import com.github.eniqen.algo.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class SameTree {
	public static void main(String[] args) {
		TreeNode l = TreeNode.of(1, TreeNode.of(2), TreeNode.of(3));
		TreeNode r = TreeNode.of(1, TreeNode.of(2), TreeNode.of(3));
		System.out.println(isSameTreeRec(l, r));
		System.out.println(isSameTree(l, r));
	}

	private static boolean isSameTreeRec(TreeNode p, TreeNode q) {
		if(p == null && q == null) return true;
		else if(p == null || q == null) return false;
		else if(p.val != q.val) return false;
		else return isSameTreeRec(p.left, q.left) && isSameTreeRec(p.right, q.right);
	}

	private static boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null) return true;
		if(p == null || q == null) return false;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(p);
		queue.offer(q);
		while(!queue.isEmpty()) {
			TreeNode left = queue.poll();
			TreeNode right = queue.poll();

			if(left == null && right == null) continue;
			if(left == null || right == null) return false;
			if(left.val != right.val) return false;

			queue.offer(left.left);
			queue.offer(right.left);
			queue.offer(left.right);
			queue.offer(right.right);
		}

		return true;
	}
}
