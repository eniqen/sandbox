package com.github.eniqen.algo.leetcode.tree.bfs;

import com.github.eniqen.algo.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class AverageOfLevels {
	public static void main(String[] args) {
		TreeNode root = TreeNode.of(3, TreeNode.of(9), TreeNode.of(20, TreeNode.of(15), TreeNode.of(7)));
		System.out.println(averageOfLevels(root));
	}

	private static List<Double> averageOfLevels(TreeNode root) {
		if(root == null) return new LinkedList<>();
		Queue<TreeNode> levels = new LinkedList<>();
		List<Double> result = new ArrayList<>();
		levels.add(root);
		while(!levels.isEmpty()) {
			int size = levels.size();
			double avg = 0d;
			for(int i = 0; i < size; i++) {
				TreeNode cur = levels.remove();
				avg += cur.val;
				if(cur.left != null) levels.add(cur.left);
				if(cur.right != null) levels.add(cur.right);
			}
			result.add(avg / size);
		}

		return result;
	}
}
