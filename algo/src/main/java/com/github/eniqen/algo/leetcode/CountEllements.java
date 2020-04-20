package com.github.eniqen.algo.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class CountEllements {
	public static void main(String[] args) {
		int [] data = new int[] { 1, 2, 3 };
		System.out.println(countElements(data));
 	}

	static int countElements(int[] arr) {
		Set<Integer> store = new HashSet<>(arr.length - 1);
		for(Integer cur: arr) {
			store.add(cur);
		}

		int result = 0;
		for(Integer curr: arr) {
			Integer next = curr + 1;
			if(store.contains(next)) {
				result++;
			}
		}
		return result;
	}
}

