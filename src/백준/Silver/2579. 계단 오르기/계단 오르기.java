import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[n + 1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = score[1];
        dp[1][1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 2][1] + score[i], dp[i - 2][0] + score[i]);
            dp[i][1] = dp[i - 1][0] + score[i];
        }
        System.out.println(Math.max(dp[n][0], dp[n][1]));
    }
}