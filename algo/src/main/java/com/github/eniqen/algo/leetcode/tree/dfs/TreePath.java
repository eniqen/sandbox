package com.github.eniqen.algo.leetcode.tree.dfs;

import com.github.eniqen.algo.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class TreePath {
	public static void main(String[] args) {
		TreeNode tree = TreeNode.of(1, TreeNode.of(2, null, TreeNode.of(5)), TreeNode.of(3));
		System.out.println(binaryTreePaths(tree));
	}

	private static List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<>();
		if(root == null) return result;

		binaryTreePathsRec(root, result, Integer.toString(root.val));
		return result;
	}

	private static void binaryTreePathsRec(TreeNode root, List<String> result, String pathPrefix) {
		if(root == null) return;
		if(root.left == null && root.right == null) result.add(pathPrefix);
		if(root.left != null) binaryTreePathsRec(root.left, result, pathPrefix + "->" + root.left.val);
		if(root.right != null) binaryTreePathsRec(root.right, result, pathPrefix + "->" + root.right.val);
	}
}
