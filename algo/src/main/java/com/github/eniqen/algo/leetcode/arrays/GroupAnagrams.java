package com.github.eniqen.algo.leetcode.arrays;

import java.util.*;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class GroupAnagrams {
	public static void main(String[] args) {
		String [] data = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(data));
 	}

	 static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> dict = new HashMap<>(strs.length -1);
		for(String cur: strs) {
			char[] currentChars = cur.toCharArray();
			Arrays.sort(currentChars);
			String key = new String(currentChars);
			List<String> values = dict.get(key);
			if(values != null) {
				values.add(cur);
			} else {
				List<String> newValue = new LinkedList<>();
				newValue.add(cur);
				dict.put(key, newValue);
			}
		}

		return new LinkedList<>(dict.values());
	}
}
