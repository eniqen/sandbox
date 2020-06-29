package com.github.eniqen.algo.leetcode;

/**
 * @author Mikhail Nemenko {@literal <nemenkoma@gmail.com>}
 */
class MaxAvgSubarray {

    public static void main(String[] args) {
        int [] data = new int[] {-1};
        int k = 1;

        System.out.println(findMaxAverage(data, k));
    }
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        double maxAvg = Double.NEGATIVE_INFINITY;
        int start = 0;

        for(int end = 0; end < nums.length; end++) {
            sum += nums[end];

            if(end >= k - 1) {
                maxAvg = Math.max(maxAvg, (double)sum / k);
                sum -= nums[start];
                start++;
            }
        }
        return maxAvg;
    }
}