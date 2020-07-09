package com.github.eniqen.algo.leetcode;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	private TreeNode() {}

	public TreeNode(int val) { this(val, null, null); }

	private TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public static TreeNode of(int val, TreeNode left, TreeNode right) {
		return new TreeNode(val, left, right);
	}

	public static TreeNode of(int val) {
		return of(val, null, null);
	}
}
