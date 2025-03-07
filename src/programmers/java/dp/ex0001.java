package programmers.java.dp;

import java.util.Arrays;

// DP 동적계획법 활용
// 갯수 제한 있는 거스름돈 동전 갯수 반환하기
// 거슬러줄 수 없는 돈은 -1 반환
public class ex0001 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 5, 10}, new int[]{3, 2, 2}, 13));

    }

    private static int coinChange(int[] coins, int[] limit, int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            int maxUse = limit[i];

            for (int j = n; j >= 0; j--) {
                if (dp[j] == Integer.MAX_VALUE) continue;

                for (int k = 1; k <= maxUse && k * coin + j <= n; k++) {
                    dp[k * coin + j] = Math.min(dp[j] + k, dp[k * coin + j]);
                }
            }
        }
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }

}
