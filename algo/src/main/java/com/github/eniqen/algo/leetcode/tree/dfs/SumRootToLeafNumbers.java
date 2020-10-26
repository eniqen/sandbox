package com.github.eniqen.algo.leetcode.tree.dfs;

import com.github.eniqen.algo.leetcode.TreeNode;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class SumRootToLeafNumbers {
	public static void main(String[] args) {
		TreeNode node = TreeNode.of(1, TreeNode.of(2), TreeNode.of(3));
		System.out.println(sumNumbersRec(node));
	}

	private static int sumNumbersRec(TreeNode root) {
		if(root == null) return 0;
		if(root.left == null && root.right == null) return root.val;
		if(root.left != null) root.left.val += root.val * 10;
		if(root.right != null) root.right.val += root.val * 10;
		return sumNumbersRec(root.left) + sumNumbersRec(root.right);
	}
}
