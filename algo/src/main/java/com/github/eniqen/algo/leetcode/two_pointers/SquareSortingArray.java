package com.github.eniqen.algo.leetcode.two_pointers;


import java.util.Arrays;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class SquareSortingArray {
    public static void main(String[] args) {
        int [] raw = new int[]{-2, -1, 0, 2, 3};
//        System.out.println(Arrays.toString(raw));
//        System.out.println((int)Math.pow(-3, 2));
        System.out.println(Arrays.toString(makeSquares(raw)));


    }

    private static int[] makeSquares(int [] arr) {
        int [] result = new int[arr.length];

        int neg = 0;
        int pos = arr.length - 1;
        while(neg <= pos) {

            int left = (int)Math.pow(arr[neg], 2);
            int right = (int)Math.pow(arr[pos], 2);

            if(left > right) {
                result[pos-neg] = left;
                neg++;
            } else {
                result[pos-neg] = right;
                pos--;
            }
        }
        return result;
    }
}
