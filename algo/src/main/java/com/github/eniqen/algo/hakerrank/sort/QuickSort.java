package com.github.eniqen.algo.hakerrank.sort;

import java.util.Arrays;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class QuickSort {
	public static void main(String[] args) {
		Integer [] array = new Integer[] {7, 3 , 1 , 2, 4, 5, 9};
		sort(array);
		System.out.println(Arrays.toString(array));
	}

	public static <T extends Comparable<T>> void sort(T[] array) {
		innerSort(array, 0, array.length -1);
	}

	private static <T extends Comparable<T>> void innerSort(T[] array, int start, int end) {
		if(start >= end) return;
		T pivot = array[(start + end) / 2];
		int partition = partition(array, start, end, pivot);
		innerSort(array, start, partition - 1);
		innerSort(array, partition, end);
	}

	private static<T extends Comparable<T>> int partition(T[] array, int start, int end, T pivot) {
		while(start <= end) {
			while(array[start].compareTo(pivot) < 0) {
				start++;
			}

			while(array[end].compareTo(pivot) > 0) {
				end--;
			}

			if(start <= end) {
				swap(array, start, end);
				start++;
				end--;
			}
		}
		return start;
	}

	private static <T> void swap(T[] array, int from, int to) {
		T temp = array[from];
		array[from] = array[to];
		array[to] = temp;
	}
}
