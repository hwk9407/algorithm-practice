package leetcode.java;

import java.util.Arrays;

/*
2025-02-02
https://leetcode.com/problems/running-sum-of-1d-array/description/
1480. Running Sum of 1d Array
 */
class Solution1480 {

    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        return nums;
    }

    public static void main(String[] args) {
        Solution1480 solution = new Solution1480();
        System.out.println(Arrays.toString(solution.runningSum(new int[]{3,1,2,10,1})));
    }
}