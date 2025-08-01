import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        int[] weight = new int[n + 1];
        int[] value = new int[n + 1];
        int maxWeight = 0;
        for (int i = 1; i <= n; i++) {
            line = br.readLine().split(" ");
            weight[i] = Integer.parseInt(line[0]);
            value[i] = Integer.parseInt(line[1]);
            maxWeight = Math.max(maxWeight, weight[i]);
        }

        int[][] dp = new int[n + 1][k + 1];
        for (int w = 0; w <= k; w++) {
            if (w >= weight[1]) dp[1][w] = value[1];
        }

        for (int i = 2; i <= n; i++) {
            for (int w = 0; w <= k; w++) {
                dp[i][w] = dp[i - 1][w];
                if (w >= weight[i]) {
                    dp[i][w] = Math.max(dp[i][w], dp[i - 1][w - weight[i]] + value[i]);
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}