package com.github.eniqen.algo.leetcode.tree.dfs;

import com.github.eniqen.algo.leetcode.TreeNode;

import java.util.Stack;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class PathSum {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree has path: " + PathSum.hasPathSum(root, 23));
		System.out.println("Tree has path: " + PathSum.hasPathSum(root, 16));

		System.out.println("Tree has path with non rec: " + PathSum.hasPathNotRec(root, 23));
		System.out.println("Tree has path with non rec: " + PathSum.hasPathNotRec(root, 16));
	}

	private static boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
		if(root.val == sum && root.left == null && root.right == null) return true;

		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}

	private static boolean hasPathNotRec(TreeNode root, int sum) {
		if(root == null) return false;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while(!stack.isEmpty()) {
			TreeNode cur = stack.pop();

			if(cur.val == sum && cur.left == null && cur.right == null) return true;

			if(cur.right != null) {
				cur.right.val += cur.val;
				stack.push(cur.right);
			}
			if(cur.left != null) {
				cur.left.val += cur.val;
				stack.push(cur.left);
			}
		}
		return false;
	}
}
