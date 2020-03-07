package com.github.eniqen.algo.hakerrank.arrays;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class NewYearChaos {
	public static void main(String [] args) {
		final int [] queue = new int[] {2, 1, 5, 3 ,4 };
		final int [] chaoticQueue = new int[] {2, 5, 1, 3, 4};
		final int [] temp = new int[] {3, 1, 2};
		final int [] testCase2 = new int[] {1, 2, 5, 3, 4, 7, 8, 6};
		final int [] testCase3Chaotic = new int[] {5, 1, 2, 3, 7, 8, 6, 4};
		final int [] testCase4 = new int[] {1, 2, 5, 3, 7, 8, 6, 4};
 		minimumBribes(temp);
	}


	private static void minimumBribes(int[] q) {
		int bribes = 0;
		for(int i = q.length - 1; i >= 0; i--) {
			final int p = q[i];
			if(p - (i + 1) > 2) {
				bribes = -1;
				break;
			}

			for(int j = Math.max(0, p - 2); j < i; j++) {
				if(q[j] > q[i]) bribes++;
			}
		}
		System.out.println(bribes < 0 ? "Too chaotic": String.valueOf(bribes));
	}
}
