package com.github.eniqen.algo.hakerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class SockMerchant {

	public static void main(String[] args) {
		final int[] store = new int[] { 10, 20, 20, 10, 10, 30, 50, 10, 20 };
		final Map<Integer, Integer> merchant = new HashMap<>();
		final int[] sum = new int[] {0};

		for (int e: store) {
			merchant.compute(e, new BiFunction<Integer, Integer, Integer>() {
				@Override
				public Integer apply(Integer key, Integer value) {
					if (value == null) return 1;
					else if (value == 1) {
						sum[0] = sum[0] + 1;
						return 0;
					}
					else return value + 1;
				}
			});
		}

		System.out.println(sum[0]);
	}
}
