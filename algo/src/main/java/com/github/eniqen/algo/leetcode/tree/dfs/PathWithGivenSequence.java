package com.github.eniqen.algo.leetcode.tree.dfs;

import com.github.eniqen.algo.leetcode.TreeNode;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class PathWithGivenSequence {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);

		System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
		System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
	}

	public static boolean findPath(TreeNode root, int[] sequence) {
		return pathRec(root, sequence, 0);
	}

	private static boolean pathRec(TreeNode root, int[] sequence, int index) {
		if(root == null || index >= sequence.length) return false;
		if(root.left == null && root.right == null && sequence.length - 1 == index && sequence[index] == root.val) return true;
		return pathRec(root.left, sequence, index + 1) || pathRec(root.right, sequence, index + 1);
	}
}
