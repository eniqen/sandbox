package com.github.eniqen.algo;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class GoogleFooBar {
	//	For example, given the lists x = [13, 5, 6, 2, 5] and y = [5, 2, 5, 13],
//	the function solution(x, y) would return 6 because the list x contains the
//	integer 6 and the list y doesn't. Given the lists x = [14, 27, 1, 4,
//			2, 50, 3, 1] and y = [2, 4, -4, 3, 1, 1, 14, 27, 50], the function
//	solution(x, y) would return -4 because the list y contains the integer -4
//	and the list x doesn't.
//
//	In each test case, the lists x and y will always contain n non-unique
//	integers where n is at least 1 but never more than 99, and one of the
//	lists will contain an additional unique integer which should be returned
//	by the function.  The same n non-unique integers will be present on both
//	lists, but they might appear in a different order, like in the examples
//	above. Commander Lambda likes to keep her numbers short, so every prisoner
//	ID will be between -1000 and 1000.
	public static void main(String[] args) {
		int[] x = new int[]{14, 27, 1, 4, 2, 30, 3, 1};
		int[]y = new int[]{2, 4, -4, 3, 1, 1, 14, 27, 30};

		int[] x1 = new int[]{13, 5, 6, 2, 5};
		int [] y1 = new int[]{5, 2, 5, 13};

		int[] x11 = new int[]{3, 5};
		int [] y11 = new int[]{5, 2, 3};
		System.out.println(solution(x , y));
		System.out.println(solution(x1 , y1));
		System.out.println(solution(x11 , y11));
	}

	public static int solution(int[] x, int[] y) {
		int[] numbers = new int[2001];
		int[] numbers2 = new int[2001];
		int c = 1000;

		int result = 0;
		for (int aX : x) numbers[aX + c]++;
		for (int aY : y) numbers2[aY + c]++;
		int i = 0;
		while(i < x.length || i < y.length) {
			if(i < x.length && --numbers2[x[i] + c] < 0) return x[i];
			if(i < y.length && --numbers[y[i] + c] < 0) return y[i];
			i++;
		}
		return result;
	}
}
