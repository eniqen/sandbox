package com.github.eniqen.algo.leetcode.cyclic_sort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
public class FirstKMissed {
	public static void main(String[] args) {
		List<Integer> missingNumbers = FirstKMissed.findNumbers(new int[] { 3, -1, 4, 5, 5 }, 3);
		System.out.println("Missing numbers: " + missingNumbers);

		missingNumbers = FirstKMissed.findNumbers(new int[] { 2, 3, 4 }, 3);
		System.out.println("Missing numbers: " + missingNumbers);

		missingNumbers = FirstKMissed.findNumbers(new int[] { -2, -3, 4 }, 2);
		System.out.println("Missing numbers: " + missingNumbers);
	}


	public static List<Integer> findNumbers(int[] nums, int k) {
		List<Integer> missingNumbers = new ArrayList<>();
		int i = 0;
		while(i < nums.length) {
			if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
				int tmp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = tmp;
			} else {
				i++;
			}
		}
		Set<Integer> extra = new HashSet<>();
		for(i = 0; i < nums.length && missingNumbers.size() < k; i++) {
			if(nums[i] != i + 1) {
				missingNumbers.add(i + 1);
				extra.add(nums[i]);
			}
		}

		for(i = 1; missingNumbers.size() < k; i++) {
			int toAdd = i + nums.length;
			if(!extra.contains(toAdd)) {
				missingNumbers.add(toAdd);
			}
		}

		return missingNumbers;
	}
}
