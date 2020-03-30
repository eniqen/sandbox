package com.github.eniqen.algo.hakerrank.sort;

import java.util.Arrays;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class MergeSort {
	public static void main(String[] args) {
		int [] array = new int[] {2, 3, 1, 4};
		mergeSort(array);
		System.out.println(Arrays.toString(array));
	}

	private static void mergeSort(int [] array) {
		mergeSortInner(array, new int[array.length], 0, array.length - 1);
	}

	private static void mergeSortInner(int[] array, int [] temp, int start, int end) {
		if(start >= end) return;
		int middle = (start + end) / 2;
		mergeSortInner(array, temp, start, middle);
		mergeSortInner(array, temp, middle + 1, end);
		mergeHalves(array, temp, start, end);
	}

	private static void mergeHalves(int[] array, int[] temp, int start, int end) {
 		int leftEnd = (start + end) / 2;
		int rightStart = leftEnd + 1;
		int size = end - start + 1;

		int index = start;
		int left = start;
		int right = rightStart;

		while(left <= leftEnd && right <= end) {
			if(array[left] <= array[right]) {
				temp[index] = array[left];
				left++;
			} else {
				temp[index] = array[right];
				right++;
			}
			index++;
		}

		System.arraycopy(array, left, temp, index, leftEnd - left + 1);
		System.arraycopy(array, right, temp, index, end - right + 1);
		System.arraycopy(temp, start, array, start, size);
	}
}
