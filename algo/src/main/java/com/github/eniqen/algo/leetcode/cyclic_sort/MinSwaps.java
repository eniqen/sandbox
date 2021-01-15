package com.github.eniqen.algo.leetcode.cyclic_sort;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class MinSwaps {
    public static void main(String[] args) {
        int [] arr = new int[] { 7, 1, 3, 2, 4, 5, 6};
        System.out.println(minimumSwaps(arr));
    }

    static int minimumSwaps(int[] arr) {
        int m = 0;
        for(int i = 0; i < arr.length; i++) {
            while(arr[i] != i + 1) {
                swap(arr, i, arr[i] - 1);
                m++;
            }
        }
        return m;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
}
