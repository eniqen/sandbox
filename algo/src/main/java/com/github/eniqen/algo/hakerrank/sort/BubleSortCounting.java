package com.github.eniqen.algo.hakerrank.sort;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class BubleSortCounting {
	public static void main(String[] args) {
		final int[] array = new int[]{4,2,1,6};
		countSwaps(array);
	}

	private static void countSwaps(int[] a) {
		long swaps = 0L;

		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a.length - 1; j++) {
				if(a[j] > a[j + 1]) {
					final int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					swaps++;
				}
			}
		}
		System.out.printf("Array is sorted in %d swaps.\n", swaps);
		System.out.printf("First Element: %d\n", a[0]);
		System.out.printf("Last Element: %d", a[a.length - 1]);
	}
}
