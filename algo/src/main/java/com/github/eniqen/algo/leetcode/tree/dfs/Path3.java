package com.github.eniqen.algo.leetcode.tree.dfs;

import com.github.eniqen.algo.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class Path3 {
	public static void main(String[] args) {
		int sum = 8;
		TreeNode root = TreeNode.of(10, TreeNode.of(5, TreeNode.of(3, null, TreeNode.of(11)), TreeNode.of(2, TreeNode.of(3), TreeNode.of(-2, null, TreeNode.of(2)))), TreeNode.of(-3));
		System.out.println(pathSum(root, sum));
	}

	private static int pathSum(TreeNode root, int sum) {
		LinkedList<Integer> path = new LinkedList<>();
		int size = 0;
		return loop(root, sum, path, size);
	}


	private static int loop(TreeNode cur, int s, List<Integer> path, int size) {
		if(cur == null) return 0;

		path.add(cur.val);
		int pathSum = 0;
		int pathCount = 0;
		ListIterator<Integer> it = path.listIterator(++size);
		while(it.hasPrevious()) {
			pathSum += it.previous();
			if(pathSum == s) pathCount++;
		}

		pathCount += loop(cur.left, s, path, size);
		pathCount += loop(cur.right, s, path, size);

		path.remove(size - 1);

		return pathCount;
	}
}
