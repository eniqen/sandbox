package com.github.eniqen.algo.leetcode.tree.bfs;

import com.github.eniqen.algo.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class Cousins {
	public static void main(String[] args) {
		TreeNode root = TreeNode.of(1, TreeNode.of(2, null, TreeNode.of(4)), TreeNode.of(3, null, TreeNode.of(5)));
		System.out.println(isCousins(root, 5, 4));
	}

	private static boolean isCousins(TreeNode root, int x, int y) {
		List<TreeNode> parents = new LinkedList<>();
		List<Integer> levels = new LinkedList<>();
		search(root, x, y, 0, levels, parents);
		return parents.size() == 2 && levels.size() == 2 && levels.get(0).equals(levels.get(1)) && parents.get(0) != parents.get(1);
	}

	private static void search(TreeNode t, int x, int y, int level,  List<Integer> levels,  List<TreeNode> parents) {
		if(t == null) return;

		if(t.left != null && (t.left.val == x || t.left.val == y)) {
			levels.add(level + 1);
			parents.add(t);
		} else if(t.right != null && (t.right.val == x || t.right.val == y)) {
			levels.add(level + 1);
			parents.add(t);
		} else {
			search(t.left, x, y, level + 1, levels, parents);
			search(t.right, x, y, level + 1, levels, parents);
		}
	}
}
