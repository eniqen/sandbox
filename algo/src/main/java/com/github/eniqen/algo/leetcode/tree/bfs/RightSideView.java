package com.github.eniqen.algo.leetcode.tree.bfs;

import com.github.eniqen.algo.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class RightSideView {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		root.left.left.left = new TreeNode(3);
		List<TreeNode> result = RightSideView.rightSideView(root);
		for (TreeNode node : result) {
			System.out.print(node.val + " ");
		}
	}

	public static List<TreeNode> rightSideView(TreeNode root) {
		List<TreeNode> result = new ArrayList<>();
		if(root == null) return result;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i ++) {
				TreeNode cur = q.poll();
				if(i == size - 1) result.add(cur);
				if(cur.left != null) q.offer(cur.left);
				if(cur.right != null) q.offer(cur.right);
			}
		}

		return result;
	}
}
