package com.github.eniqen.algo.leetcode.tree.dfs;

import com.github.eniqen.algo.leetcode.TreeNode;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class Diameter {
	public static void main(String[] args) {

	}

	static int max = 0;

	public static int diameterOfBinaryTree(TreeNode root) {
		maxDepth(root);
		return max;
	}

	private static int maxDepth(TreeNode root) {
		if (root == null) return 0;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		max = Math.max(max, left + right);
		return Math.max(left, right) + 1;
	}
}
