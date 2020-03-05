package com.github.eniqen.algo.hakerrank;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class MaxHourGlass {
	public static void main(String[] args) {
		final int[][] matrix = new int[][] {
				{1, 1 , 1, 0, 2},
				{0, 1 , 0, 1, 1},
				{1, 1 , 1, 0, 1},
				{1, 1 , 1, 0, 1}
		};

		int DIMENSION = 3;
		Integer max = null;

		for(int row = 0; row + DIMENSION <= matrix.length; row++) {
			for(int col = 0; col + DIMENSION <= matrix[0].length; col++) {
				int sum = 0;
				int part = 0;
				for(int i = row; i < DIMENSION + row; i++) {
					for (int j = col; j < DIMENSION + col; j++) {
						if (part != 3 && part != 5) {
							sum += matrix[i][j];
						}
						part++;
					}
				}
				max = max == null ? sum : Math.max(max, sum);
			}
		}
		System.out.println(max);
	}
}