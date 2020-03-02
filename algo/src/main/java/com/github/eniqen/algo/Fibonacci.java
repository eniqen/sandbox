package com.github.eniqen.algo;


import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class Fibonacci {
	public static void main(String[] args) {
//		System.out.println(fib(696352));
		System.out.println(fib(3));
		System.out.println(fibOptimised(696352));
	}

	 private static BigInteger fib(int n) {
		if (n >= 2) return fibHelper(BigInteger.ZERO,  BigInteger.ONE, 2, n);
		else return BigInteger.valueOf(n);
	}

	private static BigInteger fibHelper(BigInteger prev, BigInteger next, int current, int till) {
		if (till <= current) return prev.add(next);
		else return fibHelper(next, prev.add(next), current + 1, till);
	}

	private static BigInteger fibOptimised(int n) {
		if (n >= 2 || n <= 10000000) {
			BigInteger[] memo = new BigInteger[]{ BigInteger.ZERO, BigInteger.ONE };
			int index = 2;
			while (n > index) {
				final BigInteger prevInner = memo[0];
				final BigInteger nextInner = memo[1];
				memo[0] = nextInner;
				memo[1] = prevInner.add(nextInner);
				index += 1;
			}
			return memo[0].add(memo[1]);
		} else return BigInteger.valueOf(n);
	}
}