package com.github.eniqen.algo.leetcode.tree.dfs;

import com.github.eniqen.algo.leetcode.TreeNode;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class MaxPathSum {
	private static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {

	}

	public static int maxPathSum(TreeNode root) {
		depth(root);
		return max;
	}

	private static int depth(TreeNode root) {
		if(root == null) return 0;
		int L = Math.max(depth(root.left), 0);
		int R = Math.max(depth(root.right), 0);
		max = Math.max(max, L + R + root.val);
		return Math.max(L, R) + root.val;
	}
}
