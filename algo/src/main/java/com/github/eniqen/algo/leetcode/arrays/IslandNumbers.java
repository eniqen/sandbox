package com.github.eniqen.algo.leetcode.arrays;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class IslandNumbers {
	public static void main(String[] args) {
		char[][] grid = new char[][]{
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '1', '0', '0'},
				{'0', '0', '0', '1', '1'}
		};
		System.out.println(numIslands(grid));
	}

	private static int numIslands(char[][] grid) {
		if(grid == null || grid.length == 0) return 0;
		int count = 0;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] == '1') count += loop(grid, i, j);
			}
		}
		return count;
	}

	private static int loop(char[][] grid, int i, int j) {
		if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') return 0;

		grid[i][j] = '0';

		loop(grid, i + 1, j);
		loop(grid, i - 1, j);
		loop(grid, i, j + 1);
		loop(grid, i, j - 1);
		return 1;
	}
}
