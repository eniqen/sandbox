package com.github.eniqen.algo.leetcode.tree.bfs;

import com.github.eniqen.algo.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class LevelOrder {
	public static void main(String[] args) {

	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		if(root == null) return new ArrayList<>();
		Queue<TreeNode> level = new LinkedList<>();
		List<List<Integer>> res = new ArrayList<>();
		level.add(root);
		while(!level.isEmpty()) {
			int size = level.size();
			ArrayList<Integer> tmp = new ArrayList<>(size);
			for(int i = 0; i < size; i++) {
				TreeNode cur = level.remove();
				tmp.add(cur.val);
				if(cur.left != null) level.add(cur.left);
				if(cur.right != null) level.add(cur.right);
			}

			res.add(tmp);
		}

		return res;
	}
}
