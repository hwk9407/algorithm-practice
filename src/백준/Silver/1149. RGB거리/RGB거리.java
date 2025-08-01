import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] score = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            String[] line = br.readLine().split(" ");
            score[i][0] = Integer.parseInt(line[0]);
            score[i][1] = Integer.parseInt(line[1]);
            score[i][2] = Integer.parseInt(line[2]);
        }
        int[][] dp = new int[n + 1][3];
        dp[1][0] = score[1][0];
        dp[1][1] = score[1][1];
        dp[1][2] = score[1][2];

        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + score[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + score[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + score[i][2];
        }

        System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));
    }
}