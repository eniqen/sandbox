package com.github.eniqen.algo.leetcode;

import java.util.Arrays;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class MoveZeroes {
	public static void main(String[] args) {
		int [] data = new int[] {0,1,0,3,12};
		moveZeroes(data);
		System.out.println(Arrays.toString(data));
	}

	static void moveZeroes(int[] nums) {
		int index = 0;
		int zeroesCount = 0;
		while(index < nums.length) {
			int current = nums[index];
			while(index < nums.length && nums[index] == 0 ) {
				index++;
				zeroesCount++;
			}

			if(current != 0 && zeroesCount > 0) {
				nums[index - zeroesCount] = current;
				nums[index] = 0;
			}

			if(current != 0)  index++;
		}
	}

	static void anotherMoveZeroes(int[] nums) {
		int anchor = 0;
		int index = 0;
		while(index < nums.length) {
			int current = nums[index];
			if (current != 0) {
				nums[index] = nums[anchor];
				nums[anchor] = current;
				anchor++;
			}
			index++;
		}
	}
}
