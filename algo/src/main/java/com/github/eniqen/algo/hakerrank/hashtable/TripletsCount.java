package com.github.eniqen.algo.hakerrank.hashtable;

import java.util.*;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class TripletsCount {
	public static void main(String[] args) {
		final Long[] array = new Long[] {
				1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L
		};

		final Long[] seccondArray = new Long[] {
				1L, 1L, 1L, 1L
		};
		final List<Long> list = Arrays.asList(array);
		final long ratio = 1;

//		System.out.println(countTriplets(list, ratio));
		System.out.println(countTripletsViaSet(Arrays.asList(seccondArray), 1));
	}

	private static long countTriplets(List<Long> arr, long r) {
		int start = 0;
		int counter = 0;
		if (arr.size() < 3) return counter;
		else {
			while(start < arr.size()) {
				Long first = arr.get(start);
				int j = start + 1;
				while(j < arr.size()) {
					Long second = arr.get(j);
					int k = j + 1;
					if(second / first != r) {
						j++;
						continue;
					}
					while(k < arr.size()) {
						Long third = arr.get(k);
						if((third / second) == r) {
							counter++;
//							System.out.format("%s %s %s\n", first, second, third);
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

	private static long countTripletsViaSet(List<Long> arr, long r) {
		int counter = 0;
		final Map<Long, Long> lookup = unique(arr);

		for(int i = 0; i < arr.size() - 2; i++) {
			Long ell = arr.get(i);
			Long s = ell * r;
			Long t = s * r;

			Long fistResult = lookup.get(ell);

			lookup.put(ell, Math.max(0, fistResult - 1));
			Long secondResult = lookup.get(s);
			Long thirdResult = lookup.get(t);

			if(secondResult != null&& thirdResult != null)
					counter += secondResult * thirdResult;
		}

		return counter;
	}

		private static Map<Long, Long> unique(List<Long> arr) {
		final Map<Long, Long> result = new HashMap<>();
		for(Long ell: arr) {
			result.merge(ell, 1L, Long::sum);
		}
		return result;
	}

}
