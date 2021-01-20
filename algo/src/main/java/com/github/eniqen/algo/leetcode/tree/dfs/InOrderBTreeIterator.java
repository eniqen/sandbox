package com.github.eniqen.algo.leetcode.tree.dfs;

import com.github.eniqen.algo.leetcode.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class InOrderBTreeIterator {
	public static void main(String[] args) {

	}

	final private class BSTIterator {
		Iterator<Integer> it;
		public BSTIterator(TreeNode root) {
			List<Integer> r = new LinkedList<>();
			inOrder(root, r);
			this.it = r.iterator();
		}

		public int next() {
			return it.next();
		}

		public boolean hasNext() {
			return it.hasNext();
		}

		private void inOrder(TreeNode r, List<Integer> acc) {
			if(r == null) return;

			inOrder(r.left, acc);
			if(r != null) acc.add(r.val);
			inOrder(r.right, acc);
		}
	}
}


