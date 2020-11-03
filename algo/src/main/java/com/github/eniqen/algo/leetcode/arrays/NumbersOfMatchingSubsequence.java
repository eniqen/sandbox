package com.github.eniqen.algo.leetcode.arrays;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class NumbersOfMatchingSubsequence {

	final static class Item {
		int index;
		String word;

		private Item(String w, int i) {
			this.index = i;
			this.word = w;
		}

		public static Item of(String w, int i) {
				return new Item(w, i);
		}
	}

	public static void main(String[] args) {
		String pattern  = "abcde";
		String[] words = new String[]{"a","bb","acd","ace"};
		System.out.println(numMatchingSubseq(pattern, words));
	}

	public static int numMatchingSubseq(String S, String[] words) {
		Queue<Item>[] tracker = new Queue[26];
		for(int i = 'a'; i <= 'z'; i++) tracker[i - 'a'] = new LinkedList<>();
		for(String w: words) tracker[w.charAt(0) - 'a'].add(Item.of(w, 0));
		int count = 0;
		for(char c: S.toCharArray()) {
			Queue<Item> itemQ = tracker[c - 'a'];
			int size = itemQ.size();
			for(int i = 0; i < size; i ++) {
				Item item = itemQ.poll();
				if(item.index + 1 == item.word.length()) {
					count++;
				} else {
					tracker[item.word.charAt(++item.index) - 'a'].add(item);
				}
			}
		}
		return count;
	}
}
