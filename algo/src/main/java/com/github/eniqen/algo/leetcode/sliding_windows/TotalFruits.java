package com.github.eniqen.algo.leetcode.sliding_windows;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class TotalFruits {
    public static void main(String[] args) {
        int[] tree = new int[] {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(tree));
    }

    public static int totalFruit(int[] tree) {
        Map<Integer, Integer> freq = new HashMap<>();
        int start = 0;
        int maxLength = 0;
        for(int end = 0; end < tree.length; end++) {
            Integer curr = tree[end];
            freq.put(curr, freq.getOrDefault(curr, 0) + 1);

            while(freq.size() > 2) {
                Integer toShrink = tree[start];
                freq.put(toShrink, freq.get(toShrink) - 1);
                if(freq.get(toShrink) == 0) {
                    freq.remove(toShrink);
                }
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
