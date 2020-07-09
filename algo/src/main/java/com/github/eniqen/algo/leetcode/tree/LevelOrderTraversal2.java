package com.github.eniqen.algo.leetcode.tree;

import com.github.eniqen.algo.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class LevelOrderTraversal2 {
	public static void main(String[] args) {

		TreeNode root = TreeNode.of(3, TreeNode.of(9), TreeNode.of(20, TreeNode.of(15), TreeNode.of(7)));
		System.out.println(levelOrderBottom(root));
	}

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> result = new LinkedList<>();
		if(root == null) return result;

		Queue<TreeNode> level = new LinkedList<>();
		level.add(root);

		while(!level.isEmpty()) {
			int size = level.size();
			LinkedList<Integer> inner = new LinkedList<>();
			for(int index = 0; index < size; index++) {
				TreeNode current = level.remove();
				inner.add(current.val);

				if(current.left != null) level.add(current.left);
				if(current.right != null) level.add(current.right);
			}

			result.addFirst(inner);
		}
		return result;
	}
}
