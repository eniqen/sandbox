package com.github.eniqen.algo.leetcode.tree.bfs;

import com.github.eniqen.algo.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class ZigZagLevelOrder {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
		List<List<Integer>> result = ZigZagLevelOrder.zigzagLevelOrder(root);
		System.out.println("Zigzag traversal: " + result);
	}

	private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null) return result;

		Queue<TreeNode> levels = new LinkedList<>();
		levels.offer(root);
		int level = 0;
		while(!levels.isEmpty()) {
			int size = levels.size();
			List<Integer> tmp = new LinkedList<>();
			for(int i = 0; i < size; i++) {
				TreeNode cur = levels.poll();
				if(level % 2 == 0) {
					tmp.add(cur.val);
				} else {
					tmp.add(0, cur.val);
				}
				if(cur.left != null) levels.offer(cur.left);
				if(cur.right != null) levels.offer(cur.right);
			}
			level++;
			result.add(tmp);
		}

		return result;
	}
}
