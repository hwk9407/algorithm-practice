package leetcode.java;

/*
2025-02-02
https://leetcode.com/problems/richest-customer-wealth/description/
1672. Richest Customer Wealth
 */
class Solution1672 {

    public int maximumWealth(int[][] accounts) {
        int maxValue = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            maxValue = Math.max(maxValue, sum);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        Solution1672 sol = new Solution1672();
        System.out.println(sol.maximumWealth(new int[][]{{2, 8, 7}, {7, 1, 3}, {1, 9, 5}}));
    }
}