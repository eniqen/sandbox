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
		System.out.println(avg(root));
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

	private static List<Double> avg(TreeNode root) {
		if(root == null) return new ArrayList<>();
		List<Integer> sum = new ArrayList<>();
		List<Integer> counts = new ArrayList<>();
		avgRec(root, sum, counts, 0);
		List<Double> result = new ArrayList<>();

		for(int i = 0; i < counts.size(); i++) {
			result.add(1.0 * sum.get(i) / counts.get(i));
		}
		return result;
	}

	private static void avgRec(TreeNode t, List<Integer> s, List<Integer> c, int level) {
		if(t == null) return;

		if(level < s.size()) {
			s.set(level, s.get(level) + t.val);
			c.set(level, c.get(level) + 1);
		} else {
			s.add(t.val);
			c.add(1);
		}

		avgRec(t.left, s, c, level + 1);
		avgRec(t.right, s, c, level + 1);
	}
}
