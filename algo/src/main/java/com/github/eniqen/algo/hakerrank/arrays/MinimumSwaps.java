package com.github.eniqen.algo.hakerrank.arrays;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class MinimumSwaps {
	public static void main(String[] args) {
		final int [] arr = new int[] { 4, 3, 1, 2 };
		System.out.println(minimunSwaps(arr));
	}

	private static int minimunSwaps(int[] arr) {
		int counter = 0;
		int pivotIndex = (arr.length - 1) / 2;

		int start = 0;
		int end = pivotIndex;
		while(start <= pivotIndex) {
			if(arr[start] > arr[end]) {
				swap(arr, start, end);
				counter++;
			}
		}

		return counter;
	}

	private static void swap(int[] arr, int from, int to) {
		int temp = arr[from];
		arr[from] = arr[to];
		arr[to] = temp;
	}
}
