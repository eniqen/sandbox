package com.github.eniqen.algo.leetcode.two_pointers;

import java.util.Arrays;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class DublicateRemover {
    public static void main(String[] args) {
        int [] data = new int[] {2, 3, 3, 3, 6, 9, 9};
        System.out.println(removeInPlace(data));
        System.out.println(Arrays.toString(data));

        data = new int[] { 2, 2, 2, 11 };
        System.out.println(removeInPlace(data));
        System.out.println(Arrays.toString(data));
    }

    private static int removeInPlace(int[] data) {
        int dublicatePointer = 1;
        for(int end = 1; end < data.length; end++) {
            if(data[dublicatePointer - 1] != data[end]) {
                data[dublicatePointer] = data[end];
                dublicatePointer++;
            }
        }

        return dublicatePointer;
    }
}
