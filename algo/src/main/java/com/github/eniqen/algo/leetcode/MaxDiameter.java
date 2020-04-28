package com.github.eniqen.algo.leetcode;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class MaxDiameter {
	public static void main(String[] args) {
		int [] diameter = new int[] { 1 };

		TreeNode root = TreeNode.of(1, TreeNode.of(2, TreeNode.of(4), TreeNode.of(5)), TreeNode.of(3));

		maxDiameter(root, diameter);
		System.out.println(diameter[0] - 1);
	}

	private static int maxDiameter(TreeNode root, int[] result) {
		if(root == null) return 0;

		int l = maxDiameter(root.left, result);
		int r = maxDiameter(root.right, result);

		result[0] = Math.max(result[0], l + r + 1);

		return Math.max(l, r) + 1;
	}
}
