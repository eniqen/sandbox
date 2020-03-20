package com.github.eniqen.algo.hakerrank.hashtable;

import java.util.Arrays;
import java.util.List;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class TripletsCount {
	public static void main(String[] args) {
		final Long[] array = new Long[] { 1L, 3L, 9L, 9L, 27L, 81L };
		final List<Long> list = Arrays.asList(array);
		final long ratio = 3;

		System.out.println(countTriplets(list, ratio));
	}

	private static long countTriplets(List<Long> arr, long r) {
		int start = 0;
		int counter = 0;
		if (arr.size() < 3) return counter;
		else {
			while(start < arr.size()) {
				int j = start + 1;
				while(j < arr.size()) {
					int k = j + 1;
					while(k < arr.size()) {
						Long first = arr.get(start);
						Long second = arr.get(j);
						Long third = arr.get(k);
						if(second / first == r && (third / second) == r) {
							counter++;
							System.out.format("%s %s %s\n", first, second, third);
						}
						k++;
					}
					j++;
				}
				start++;
			}
		}
		return counter;
	}
}
